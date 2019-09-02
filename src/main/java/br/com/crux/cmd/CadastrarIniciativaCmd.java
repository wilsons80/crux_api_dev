package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MetasTOBuilder;
import br.com.crux.dao.repository.IniciativaRepository;
import br.com.crux.dao.repository.MetasRepository;
import br.com.crux.entity.Iniciativa;
import br.com.crux.entity.Metas;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosIniciativaRule;
import br.com.crux.to.IniciativaTO;

@Component
public class CadastrarIniciativaCmd {

	@Autowired private IniciativaRepository iniciativaRepository;
	@Autowired private MetasRepository metasRepository;
	
	@Autowired private MetasTOBuilder metasTOBuilder; 
	@Autowired private CamposObrigatoriosIniciativaRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(IniciativaTO to) {
		
		if(Objects.isNull(to.getMetas())) {
			throw new ParametroNaoInformadoException("Meta não foi informada.");
		}
		
		Optional<Metas> objetivo = metasRepository.findById(to.getMetas().getId());
		if(!objetivo.isPresent()) {
			throw new NotFoundException("Meta informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getMetas().getId());
		
		Iniciativa entity = new Iniciativa();

		entity.setNome(to.getNome());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		entity.setMeta(metasTOBuilder.build(to.getMetas()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		iniciativaRepository.save(entity);
		
	}
}
