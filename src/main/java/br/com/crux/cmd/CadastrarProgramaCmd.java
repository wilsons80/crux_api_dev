package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.dao.repository.IniciativaRepository;
import br.com.crux.dao.repository.ProgramaRepository;
import br.com.crux.entity.Iniciativa;
import br.com.crux.entity.Programa;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosProgramaRule;
import br.com.crux.to.ProgramaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarProgramaCmd {

	@Autowired private ProgramaRepository repository;
	
	@Autowired private IniciativaRepository iniciativaRepository;
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder; 
	
	@Autowired private CamposObrigatoriosProgramaRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(ProgramaTO to) {
		
		if(Objects.isNull(to.getIniciativa())) {
			throw new ParametroNaoInformadoException("Iniciativa não foi informada.");
		}
		
		Optional<Iniciativa> iniciativa = iniciativaRepository.findById(to.getIniciativa().getId());
		if(!iniciativa.isPresent()) {
			throw new NotFoundException("Iniciativa informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIniciativa().getId());
		
		Programa entity = new Programa();

		entity.setNome(to.getNome());
		entity.setDescricao(to.getDescricao());
		
		entity.setIdCoordenador(to.getIdCoordenador());
		
		entity.setFaixaEtariaFim(to.getFaixaEtariaFim());
		entity.setFaixaEtariaInicio(to.getFaixaEtariaInicio());
		
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		entity.setIniciativa(iniciativaTOBuilder.build(to.getIniciativa()));
		entity.setObjetivo(iniciativa.get().getMeta().getIndicadores().getObjetivo());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
