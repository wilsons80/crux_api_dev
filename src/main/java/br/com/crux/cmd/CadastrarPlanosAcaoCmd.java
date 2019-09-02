package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.dao.repository.IniciativaRepository;
import br.com.crux.dao.repository.PlanosAcaoRepository;
import br.com.crux.entity.Iniciativa;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosIniciativaRule;
import br.com.crux.to.PlanosAcaoTO;

@Component
public class CadastrarPlanosAcaoCmd {

	@Autowired private PlanosAcaoRepository repository;
	
	@Autowired private IniciativaRepository iniciativaRepository;
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder; 
	
	@Autowired private CamposObrigatoriosIniciativaRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(PlanosAcaoTO to) {
		
		if(Objects.isNull(to.getIniciativa())) {
			throw new ParametroNaoInformadoException("Meta não foi informada.");
		}
		
		Optional<Iniciativa> objetivo = iniciativaRepository.findById(to.getIniciativa().getId());
		if(!objetivo.isPresent()) {
			throw new NotFoundException("Meta informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIniciativa().getId());
		
		PlanosAcao entity = new PlanosAcao();

		entity.setNome(to.getNome());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		entity.setIniciativa(iniciativaTOBuilder.build(to.getIniciativa()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
