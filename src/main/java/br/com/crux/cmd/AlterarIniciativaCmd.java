package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MetasTOBuilder;
import br.com.crux.dao.repository.IniciativaRepository;
import br.com.crux.entity.Iniciativa;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosMetasRule;
import br.com.crux.to.IniciativaTO;

@Component
public class AlterarIniciativaCmd {

	@Autowired private IniciativaRepository iniciativaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private MetasTOBuilder metasTOBuilder;
	@Autowired private CamposObrigatoriosMetasRule camposObrigatoriosRule;
	
	
	public void alterar(IniciativaTO to) {
		Optional<Iniciativa> entityOptional = iniciativaRepository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Iniciativa informada não existe.");
		}
		
		if(Objects.isNull(to.getMetas())) {
			throw new NotFoundException("Meta não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getMetas().getId());
		
		Iniciativa entityUpdate = entityOptional.get();

		entityUpdate.setNome(to.getNome());
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());

		entityUpdate.setMeta(metasTOBuilder.build(to.getMetas()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		iniciativaRepository.save(entityUpdate);
		
	}
}
