package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosColaboradoresProgramaRule {

	public void verificar(LocalDateTime dataInicio, Long idFuncionario, Long idPrograma , Long idCargo) {
		if(Objects.isNull(dataInicio)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}

		if(Objects.isNull(idFuncionario)) {
			throw new CamposObrigatoriosException("Funcionário deve ser informado.");
		}
		
		if(Objects.isNull(idPrograma)) {
			throw new CamposObrigatoriosException("Programa deve ser informado.");
		}

		if(Objects.isNull(idCargo)) {
			throw new CamposObrigatoriosException("Cargo deve ser informado.");
		}
		
	}
}