package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosFuncionarioRule {

	public void verificar(String matricula, LocalDateTime dataAdimissao, Long idCargo, Long idPessoaFisica, Long idUnidade, Long idEmpresaFuncionario) {
		if(Objects.isNull(dataAdimissao)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}
		
		if(StringUtils.isEmpty(matricula)) {
			throw new CamposObrigatoriosException("Matrícula deve ser informada.");
		}
		if(Objects.isNull(idCargo)) {
			throw new CamposObrigatoriosException("Cargo deve ser informado.");
		}
		if(Objects.isNull(idUnidade)) {
			throw new CamposObrigatoriosException("Unidade deve ser informada.");
		}
//		if(Objects.isNull(idPessoaFisica)) {
//			throw new CamposObrigatoriosException("Pessoa Física deve ser informada.");
//		}
		
		if(Objects.isNull(idEmpresaFuncionario)) {
			throw new CamposObrigatoriosException("Empresa do funcionário deve ser informada.");
		}
	}
}
