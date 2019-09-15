package br.com.crux.cmd;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.crux.dao.repository.ArquivoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Arquivo;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.UploadArquivoException;
import br.com.crux.infra.util.MD5Util;

@Component
public class ArquivoCmd {

	@Autowired private ArquivoRepository arquivoRepository;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private GetUnidadePorIdCmd getUnidadePorIdCmd;
	
	
	public void salvar(MultipartFile file) {
		gravar(file);
	}
	
	
	private void gravar(MultipartFile file) {
		try {
			String hashArquivo = MD5Util.getHashArquivo(file.getBytes());
			
			Unidade unidade = getUnidadePorIdCmd.getUnidade(getUnidadeLogadaCmd.get().getId());
			
			Arquivo arquivo = new Arquivo();
			arquivo.setBlob(file.getBytes());
			arquivo.setDtCriacao(new Date());
			arquivo.setHash(hashArquivo);
			arquivo.setNmArquivo(file.getOriginalFilename());
			arquivo.setNrTamanhoArquivo(file.getSize());
			arquivo.setDsTipoArquivo(file.getContentType());
			
			Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
			arquivo.setUsuarioAlteracao(idUsuarioLogado);
			
			Arquivo arquivoSalvo = arquivoRepository.save(arquivo);
			arquivo.setIdArquivo(arquivoSalvo.getIdArquivo());
			
			unidade.setIdArquivo(arquivo.getIdArquivo());
			unidadeRepository.save(unidade);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadArquivoException("Erro ao gravar o arquivo. " + e.getMessage());
		}
	}
	
	
	public byte[] getArquivoPorUnidade(Long idUnidade) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("Erro ao buscar o arquivo, parâmetro não informado no resource.");
		}
		
		Unidade unidade = getUnidadePorIdCmd.getUnidade(idUnidade);
		
		Optional<Arquivo> arquivo = arquivoRepository.findById(unidade.getIdArquivo());
		if(!arquivo.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o arquivo.");
		}
		
		return arquivo.get().getBlob();
	}
	

}
