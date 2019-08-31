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
public class UploadArquivoCmd {

	@Autowired
	private ArquivoRepository arquivoRepository;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	
	@Autowired
	private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired
	private GetUnidadePorIdCmd getUnidadePorIdCmd;
	
	public void salvar(Long idUnidade, MultipartFile file) {
		gravar(idUnidade, file);
	}
	
	
	private void gravar(Long idUnidade, MultipartFile file) {
		try {
			String hashArquivo = MD5Util.getHashArquivo(file.getBytes());
			
			Unidade unidade = getUnidadePorIdCmd.getUnidade(idUnidade);
			
			//novo arquivo
			if(Objects.isNull(unidade.getArquivo())) {
				Arquivo arquivo = new Arquivo();
				unidade.setArquivo(arquivo);
			}
			
			unidade.getArquivo().setBlob(file.getBytes());
			unidade.getArquivo().setDtCriacao(new Date());
			unidade.getArquivo().setHash(hashArquivo);
			unidade.getArquivo().setNmArquivo(file.getOriginalFilename());
			unidade.getArquivo().setNrTamanhoArquivo(file.getSize());
			unidade.getArquivo().setDsTipoArquivo(file.getContentType());
			
			Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
			unidade.getArquivo().setUsuarioAlteracao(idUsuarioLogado);
	
			Arquivo arquivoSalvo = arquivoRepository.save(unidade.getArquivo());
			unidade.getArquivo().setIdArquivo(arquivoSalvo.getIdArquivo());
			
			unidadeRepository.save(unidade);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadArquivoException("Erro ao gravar o arquivo. " + e.getMessage());
		}
	}
	
	
	public byte[] getArquivo(Long idArquivo) {
		if(Objects.isNull(idArquivo)) {
			throw new ParametroNaoInformadoException("Erro ao buscar o arquivo, parâmetro não informado no resource.");
		}
		
		Optional<Arquivo> arquivo = arquivoRepository.findById(idArquivo);
		if(!arquivo.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o arquivo.");
		}
		
		return arquivo.get().getBlob();
	}
	

}
