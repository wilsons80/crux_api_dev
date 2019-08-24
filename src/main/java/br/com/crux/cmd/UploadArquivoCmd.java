package br.com.crux.cmd;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.crux.dao.repository.ArquivoRepository;
import br.com.crux.entity.Arquivo;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformado;
import br.com.crux.exception.UploadArquivoException;
import br.com.crux.infra.util.MD5Util;

@Component
public class UploadArquivoCmd {

	@Autowired
	private ArquivoRepository arquivoRepository;
	
	@Autowired
	private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void atualizarArquivo(Long idArquivo, MultipartFile file) {
		gravar(idArquivo, file);
	}
	public void gravarArquivo(MultipartFile file) {
		gravar(null, file);
	}
	
	
	private void gravar(Long idArquivo, MultipartFile file) {
		try {
			String hashArquivo = MD5Util.getHashArquivo(file.getBytes());
			
			Arquivo arquivo = new Arquivo();
			
			if(Objects.nonNull(idArquivo)) {
				arquivo.setIdArquivo(idArquivo);
			}
			
			arquivo.setBlob(file.getBytes());
			arquivo.setDtCriacao(new Date());
			arquivo.setHash(hashArquivo);
			arquivo.setNmArquivo(file.getOriginalFilename());
			arquivo.setNrTamanhoArquivo(file.getSize());
			arquivo.setDsTipoArquivo(file.getContentType());
			
			Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
			arquivo.setUsuarioAlteracao(idUsuarioLogado);
	
			arquivoRepository.save(arquivo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadArquivoException("Erro ao gravar o arquivo. " + e.getMessage());
		}
	}
	
	
	public byte[] getArquivo(Long idArquivo) {
		if(Objects.isNull(idArquivo)) {
			throw new ParametroNaoInformado("Erro ao buscar o arquivo, parâmetro não informado no resource.");
		}
		
		Optional<Arquivo> arquivo = arquivoRepository.findById(idArquivo);
		if(!arquivo.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o arquivo.");
		}
		
		return arquivo.get().getBlob();
	}
	

}
