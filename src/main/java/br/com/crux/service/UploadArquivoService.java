package br.com.crux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.crux.cmd.UploadArquivoCmd;

@RestController
@RequestMapping(value = "upload")
public class UploadArquivoService {

	@Autowired
	private UploadArquivoCmd uploadArquivoCmd;
	
	@PostMapping(path = "")
	public void gravar(@RequestParam(name = "file") MultipartFile file ) {
		uploadArquivoCmd.salvar(file);
	}
	
	@PutMapping(path = "")
	public void alterar( @RequestParam(name = "file") MultipartFile file
			            ) {
		uploadArquivoCmd.salvar(file);
	}
	
	
}
