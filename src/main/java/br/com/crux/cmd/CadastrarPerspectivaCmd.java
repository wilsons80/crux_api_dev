package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.PerspectivaRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Perspectiva;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosPerspectivaRule;
import br.com.crux.to.PerspectivaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarPerspectivaCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private PerspectivaRepository perspectivaRepository;  
	@Autowired private UnidadeTOBuilder unidadeBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosPerspectivaRule camposObrigatoriosPerspectivaRule;
	
	public void cadastrar(PerspectivaTO to) {
		
		Optional<Unidade> unidade = unidadeRepository.findById(to.getUnidade().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		
		camposObrigatoriosPerspectivaRule.verificar(to.getNmPerspectiva(), to.getDtImplantacao(), to.getUnidade().getIdUnidade());
		
		Perspectiva entity = new Perspectiva();

		entity.setNmPerspectiva(to.getNmPerspectiva());
		entity.setDtImplantacao(to.getDtImplantacao());
		entity.setDtTermino(to.getDtTermino());
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		perspectivaRepository.save(entity);
		
	}
}
