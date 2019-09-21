package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosVulnerabilidadesAlunoRule {

	public void verificar(LocalDateTime dataIdentificacao, Long idVulnerabilidade, Long idSolucao, Long idAluno) {
		if(Objects.isNull(dataIdentificacao)) {
			throw new CamposObrigatoriosException("Data de Identificação deve ser informada.");
		}

		if(Objects.isNull(idVulnerabilidade)) {
			throw new CamposObrigatoriosException("Vulnerabilidade deve ser informada.");
		}

		if(Objects.isNull(idSolucao)) {
			throw new CamposObrigatoriosException("Solucao deve ser informada.");
		}
		
		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Aluno deve ser informado.");
		}
		
	}
}