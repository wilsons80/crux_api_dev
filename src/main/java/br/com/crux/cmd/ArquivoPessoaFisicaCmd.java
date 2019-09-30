package br.com.crux.cmd;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.crux.dao.repository.ArquivoRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.Arquivo;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.UploadArquivoException;
import br.com.crux.infra.util.MD5Util;

@Component
public class ArquivoPessoaFisicaCmd {

	@Autowired private ArquivoRepository arquivoRepository;
	@Autowired private PessoaFisicaRepository pessoaFisicaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private GetUnidadePorIdCmd getUnidadePorIdCmd;
	
	
	public void salvar(MultipartFile file, Long idFuncionario) {
		Arquivo arquivoSalvo = gravar(file);

		PessoaFisica pessoa = pessoaFisicaRepository.findById(idFuncionario)
		.orElseThrow(() -> new NotFoundException("Pessoa Física não encontrado."));
		
		pessoa.setIdArquivo(arquivoSalvo.getIdArquivo());
		
	}
	
	
	private Arquivo gravar(MultipartFile file) {
		try {
			String hashArquivo = MD5Util.getHashArquivo(file.getBytes());
			
			Arquivo arquivo = new Arquivo();
			arquivo.setBlob(file.getBytes());
			arquivo.setDtCriacao(new Date());
			arquivo.setHash(hashArquivo);
			arquivo.setNmArquivo(file.getOriginalFilename());
			arquivo.setNrTamanhoArquivo(file.getSize());
			arquivo.setDsTipoArquivo(file.getContentType());
			
			Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
			arquivo.setUsuarioAlteracao(idUsuarioLogado);
			
			return arquivoRepository.save(arquivo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadArquivoException("Erro ao gravar o arquivo. " + e.getMessage());
		}
	}
	
	
	//TODO FAZENDO AINDA
	public byte[] getArquivo(Long idUnidade) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("Erro ao buscar o arquivo, parâmetro não informado no resource.");
		}
		
		Unidade unidade = getUnidadePorIdCmd.getUnidade(idUnidade);
		
		if(unidade.getIdArquivo() == null) {
			return null;
		}
		
		Optional<Arquivo> arquivo = arquivoRepository.findById(unidade.getIdArquivo());
		if(!arquivo.isPresent()) {
			return null;
		}
		
		return arquivo.get().getBlob();
		
	}
	

}
