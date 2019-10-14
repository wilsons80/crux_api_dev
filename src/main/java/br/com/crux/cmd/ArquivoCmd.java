package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArquivoCmd {

	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GravarArquivoUnidadeCmd gravarArquivoUnidadeCmd;
	@Autowired private GetArquivoUnidadeCmd getArquivoUnidadeCmd;
	@Autowired private AlterarArquivoUnidadeCmd alterarArquivoUnidadeCmd;

	public void salvar(MultipartFile file) {
		gravarArquivoUnidadeCmd.gravar(file, getUnidadeLogadaCmd.get().getId());
	}

	public void salvarComIdUnidade(MultipartFile file, Long idUnidade) {
		gravarArquivoUnidadeCmd.gravar(file, idUnidade);
	}

	public byte[] getArquivoPorUnidade(Long idUnidade) {
		return getArquivoUnidadeCmd.get(idUnidade);
	}

	public void alterar(MultipartFile file, Long idUnidade) {
		alterarArquivoUnidadeCmd.alterar(file, idUnidade);
		
	}

}
