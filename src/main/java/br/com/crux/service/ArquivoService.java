package br.com.crux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.crux.cmd.ArquivoCmd;

@RestController
@RequestMapping(value = "arquivo")
public class ArquivoService {

	@Autowired
	private ArquivoCmd arquivoCmd;
	
	@PostMapping(path = "")
	public void gravar(@RequestParam(name = "file") MultipartFile file ) {
		arquivoCmd.salvar(file);
	}
	
	@PutMapping(path = "")
	public void alterar(@RequestParam(name = "file") MultipartFile file) {
		arquivoCmd.salvar(file);
	}
	
	@GetMapping(path = "/{id}")
	public byte[] get(@PathVariable(name = "id") Long id) {
		return arquivoCmd.getArquivo(id);
	}	
	
}
