package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.FamiliaresTO;

@Component
public class ExcluirFamiliaresCmd {

	@Autowired private FamiliaresRepository repository;
	@Autowired private GetFamiliaresCmd getFamiliaresCmd;
	@Autowired private ExcluirReprovacoesAlunoCmd excluirReprovacoesAlunoCmd;
	@Autowired private ExcluirPessoaFisicaCmd excluirPessoaFisicaCmd;
	
	public void excluir(Long idFamiliar) {
		if(Objects.isNull(idFamiliar)) {
			throw new ParametroNaoInformadoException("Erro ao excluir o familiar.");
		}
	
		FamiliaresTO familiaresTO = getFamiliaresCmd.getById(idFamiliar);
		
		//Apaga todos os responsáveis desse familiar.
		familiaresTO.getResponsaveis().stream().forEach(r -> excluirReprovacoesAlunoCmd.excluir(r.getId()));
			
		//Apaga o familiar
		repository.deleteById(idFamiliar);

		//Apaga a pessoa fisica
		excluirPessoaFisicaCmd.excluirPorId(familiaresTO.getPessoasFisica().getId());
	}
}
