package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.dao.repository.ProgramaRepository;
import br.com.crux.entity.Programa;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosProgramaRule;
import br.com.crux.to.ProgramaTO;

@Component
public class AlterarProgramaCmd {

	@Autowired private ProgramaRepository repository;
	@Autowired private CamposObrigatoriosProgramaRule camposObrigatoriosRule;
	
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder;
	//@Autowired private ObjetivoTOBuilder objetivoTOBuilder;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(ProgramaTO to) {
		Optional<Programa> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Programa informado não existe.");
		}
		
		if(Objects.isNull(to.getIniciativa())) {
			throw new NotFoundException("Iniciativa não informado.");
		}

		//if(Objects.isNull(to.getObjetivo())) {
		//	throw new NotFoundException("Objetivo não informado.");
		//}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIniciativa().getId());
		
		Programa entityUpdate = entityOptional.get();

		entityUpdate.setNome(to.getNome());
		entityUpdate.setDescricao(to.getDescricao());
		
		entityUpdate.setIdCoordenador(to.getIdCoordenador());
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());
		
		entityUpdate.setFaixaEtariaFim(to.getFaixaEtariaFim());
		entityUpdate.setFaixaEtariaInicio(to.getFaixaEtariaInicio());

		entityUpdate.setIniciativa(iniciativaTOBuilder.build(to.getIniciativa()));
		entityUpdate.setObjetivo(entityUpdate.getIniciativa().getMeta().getIndicadores().getObjetivo());
		
		//entityUpdate.setObjetivo(objetivoTOBuilder.build(to.getObjetivo()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entityUpdate);
		
	}
}
