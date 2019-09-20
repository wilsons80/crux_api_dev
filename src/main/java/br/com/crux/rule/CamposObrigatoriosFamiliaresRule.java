package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosFamiliaresRule {

	public void verificar(LocalDateTime dataCadastro, Long idPessoaFisica, Long idAluno) {
		if(Objects.isNull(dataCadastro)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}
		
		if(Objects.isNull(idPessoaFisica)) {
			throw new CamposObrigatoriosException("Pessoa Física deve ser informada.");
		}
		
		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Aluno deve ser informado.");
		}
		
	}
}
