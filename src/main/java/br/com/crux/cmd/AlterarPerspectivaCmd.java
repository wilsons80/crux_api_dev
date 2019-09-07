package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.PerspectivaRepository;
import br.com.crux.entity.Perspectiva;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosPerspectivaRule;
import br.com.crux.to.PerspectivaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarPerspectivaCmd {

	@Autowired private PerspectivaRepository perspectivaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private CamposObrigatoriosPerspectivaRule camposObrigatoriosPerspectivaRule;
	
	
	public void alterar(PerspectivaTO to) {
		Optional<Perspectiva> perspectivaOptional = perspectivaRepository.findById(to.getIdPerspectiva());
		if(!perspectivaOptional.isPresent()) {
			throw new NotFoundException("Perspectiva informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		
		camposObrigatoriosPerspectivaRule.verificar(to.getNmPerspectiva(), to.getDtImplantacao(), to.getUnidade().getIdUnidade());
		
		Perspectiva perspectiva = perspectivaOptional.get();

		perspectiva.setNmPerspectiva(to.getNmPerspectiva());
		perspectiva.setDtImplantacao(to.getDtImplantacao());
		perspectiva.setDtTermino(to.getDtTermino());
		perspectiva.setUnidade(unidadeBuilder.build(to.getUnidade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		perspectiva.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		perspectivaRepository.save(perspectiva);
		
	}
}
