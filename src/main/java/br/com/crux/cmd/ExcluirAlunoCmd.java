package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.AlunoTO;

@Component
public class ExcluirAlunoCmd {

	@Autowired private AlunoRepository repository;
	@Autowired private GetAlunoCmd getAlunoCmd;
	@Autowired private ExcluirAlunoCmd excluirAlunoCmd;
	@Autowired private ExcluirPessoaFisicaCmd excluirPessoaFisicaCmd;
	
	public void excluir(Long id) {
		if(Objects.isNull(id)) {
			throw new ParametroNaoInformadoException("Erro ao excluir o aluno. Parâmetro ausente.");
		}
		
		AlunoTO alunoTO = getAlunoCmd.getTOById(id);
		
		//Apaga todos as vulnerabilidades desse aluno.
		alunoTO.getVulnerabilidades().stream().forEach(r -> excluirAlunoCmd.excluir(r.getId()));
		
		repository.deleteById(id);
		
		//Apaga a pessoa fisica
		excluirPessoaFisicaCmd.excluirPorId(alunoTO.getPessoaFisica().getId());

	}
}
