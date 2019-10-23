package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.VulnerabilidadesFamiliarTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesFamiliarRepository;
import br.com.crux.entity.Familiares;
import br.com.crux.entity.VulnerabilidadesFamiliar;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.VulnerabilidadesFamiliarTO;

@Component
public class GetVulnerabilidadesFamiliarCmd {

	@Autowired private VulnerabilidadesFamiliarRepository repository;
	@Autowired private VulnerabilidadesFamiliarTOBuilder toBuilder;
	@Autowired private GetFamiliaresCmd getFamiliaresCmd;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<VulnerabilidadesFamiliar> getAllFamiliar(Long idFamiliar) {
		List<VulnerabilidadesFamiliar> retorno = new ArrayList<VulnerabilidadesFamiliar>();
		
		Familiares familiar = getFamiliaresCmd.getById(idFamiliar);
		if(Objects.isNull(familiar)) {
			throw new NotFoundException("Familiar informado não existe.");
		}
		//Long idUnidade = familiar.getAluno().getUnidade().getIdUnidade();
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		
		Optional<List<VulnerabilidadesFamiliar>> vulnerabilidades = repository.findByUnidadeAndFamiliar(idUnidade, idFamiliar);
		if(!vulnerabilidades.isPresent()) {return new ArrayList<VulnerabilidadesFamiliar>();}
		
		vulnerabilidades.get().stream().forEach(r -> retorno.add(r));
		return retorno;
		
	}
	
	public List<VulnerabilidadesFamiliarTO> getAllFamiliarTO(Long idFamiliar) {
		List<VulnerabilidadesFamiliarTO> retorno = new ArrayList<VulnerabilidadesFamiliarTO>();
		
		List<VulnerabilidadesFamiliar> vulnerabilidades = getAllFamiliar(idFamiliar);
		vulnerabilidades.stream().forEach(r -> retorno.add(toBuilder.buildTO(r)));
		
		return retorno;
	}
	
	
	public VulnerabilidadesFamiliarTO getById(Long id) {
		VulnerabilidadesFamiliar entityOptional = repository.findById(id).orElseThrow(() -> new NotFoundException("Vulnerabilidades  da Familia não encontrada."));
		return toBuilder.buildTO(entityOptional);
	}
			
}
