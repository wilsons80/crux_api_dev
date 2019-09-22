package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAtendimentosRule {

	public void verificar(LocalDateTime dataAtendimento, Long idSolucoes, Long idAluno, Long idDiagnostico) {
		if(Objects.isNull(dataAtendimento)) {
			throw new CamposObrigatoriosException("Data de atendimento deve ser informada.");
		}
		
		if(Objects.isNull(idSolucoes)) {
			throw new CamposObrigatoriosException("Solução deve ser informada.");
		}

		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Aluno deve ser informado.");
		}

		if(Objects.isNull(idDiagnostico)) {
			throw new CamposObrigatoriosException("Diagnóstico deve ser informado.");
		}

	}
}
