package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PerspectivaTOBuilder;
import br.com.crux.dao.repository.PerspectivaRepository;
import br.com.crux.entity.Perspectiva;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosPerspectivaRule;
import br.com.crux.to.PerspectivaTO;

@Component
public class AlterarPerspectivaCmd {

	@Autowired private PerspectivaRepository perspectivaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosPerspectivaRule camposObrigatoriosPerspectivaRule;
	@Autowired private PerspectivaTOBuilder perspectivaTOBuilder;

	public void alterar(PerspectivaTO to) {
		Perspectiva perspectiva = perspectivaRepository.findById(to.getIdPerspectiva()).orElseThrow(() -> new NotFoundException("Perspectiva informado não existe."));

		camposObrigatoriosPerspectivaRule.verificar(to);

		to.setUsuariosSistema(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		perspectiva = perspectivaTOBuilder.build(to);

		perspectivaRepository.save(perspectiva);

	}
}
