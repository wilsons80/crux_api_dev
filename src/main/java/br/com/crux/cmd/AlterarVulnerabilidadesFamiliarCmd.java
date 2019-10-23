package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.VulnerabilidadesFamiliarTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesFamiliarRepository;
import br.com.crux.entity.VulnerabilidadesFamiliar;
import br.com.crux.rule.CamposObrigatoriosVulnerabilidadesFamiliarRule;
import br.com.crux.to.FamiliaresTO;
import br.com.crux.to.VulnerabilidadesFamiliarTO;

@Component
public class AlterarVulnerabilidadesFamiliarCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private VulnerabilidadesFamiliarRepository repository;
	@Autowired private CamposObrigatoriosVulnerabilidadesFamiliarRule camposObrigatoriosRule;
	@Autowired private VulnerabilidadesFamiliarTOBuilder vulnerabilidadesFamiliarTOBuilder; 
	@Autowired private GetVulnerabilidadesFamiliarCmd getVulnerabilidadesFamiliarCmd;
	
	
	
	private void alterar(VulnerabilidadesFamiliarTO vulnerabilidadeTO, FamiliaresTO familiarTO) {
		camposObrigatoriosRule.verificar(vulnerabilidadeTO);
		vulnerabilidadeTO.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		VulnerabilidadesFamiliar entity = vulnerabilidadesFamiliarTOBuilder.build(vulnerabilidadeTO, familiarTO);
		repository.save(entity);
	}
	
	
	public void alterarAll(List<VulnerabilidadesFamiliarTO> responsaveisTO, FamiliaresTO familiarTO) {
		//Lista de vulnerabilidades do familiar.
		List<VulnerabilidadesFamiliar> vulnerabilidadesPorFamiliar = getVulnerabilidadesFamiliarCmd.getAllFamiliar(familiarTO.getId());
		
		BiPredicate<VulnerabilidadesFamiliarTO, List<VulnerabilidadesFamiliarTO>> contemNaLista  = (parte, lista) -> lista.stream()
                                                                                                            .anyMatch(parteNova -> parteNova.getId().equals(parte.getId()));
		
		
		//Remove da lista todos os registros que não contém no Banco de Dados
		vulnerabilidadesPorFamiliar.removeIf(registro -> {
														if(!contemNaLista.test(vulnerabilidadesFamiliarTOBuilder.buildTO(registro), responsaveisTO)){
															repository.delete(registro); 
															return true;
														}
														return false;
									                }
		                                );
		
		//Adiciona os novos registros
		List<VulnerabilidadesFamiliarTO> novos = responsaveisTO.stream()
				                                           .filter(registro -> !contemNaLista.test(registro, vulnerabilidadesFamiliarTOBuilder.buildAll(vulnerabilidadesPorFamiliar)))
				                                           .collect(Collectors.toList());
		
		if(Objects.nonNull(novos)){
			novos.forEach(novoResponsavel -> alterar(novoResponsavel, familiarTO));
		}

		//Atualiza os registros 
		responsaveisTO.stream().forEach( registro -> {
			if(contemNaLista.test(registro, vulnerabilidadesFamiliarTOBuilder.buildAll(vulnerabilidadesPorFamiliar))){
				alterar(registro, familiarTO);
			}
		});
	}

	
	
}
