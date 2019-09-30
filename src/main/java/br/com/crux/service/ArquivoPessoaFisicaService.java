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

import br.com.crux.cmd.ArquivoPessoaFisicaCmd;

@RestController
@RequestMapping(value = "arquivopessoafisica")
public class ArquivoPessoaFisicaService {

	@Autowired
	private ArquivoPessoaFisicaCmd arquivoPessoaFisicaCmd;
	
	@PostMapping(path = "/{idPessoaFisica}")
	public void gravar(@RequestParam(name = "file") MultipartFile file, @PathVariable(name = "idUsuario") Long idPessoaFisica ) {
		arquivoPessoaFisicaCmd.salvar(file, idPessoaFisica);
	}
	
	@PutMapping(path = "/{idPessoaFisica}")
	public void alterar(@RequestParam(name = "file") MultipartFile file) {
		//arquivoPessoaFisicaCmd.salvar(file);
	}
	
	@GetMapping(path = "/{idUsuario}")
	public byte[] getPorAluno(@PathVariable(name = "idUsuario") Long idPessoaFisica) {
		return arquivoPessoaFisicaCmd.getArquivo(idPessoaFisica);
	}	
	
}
