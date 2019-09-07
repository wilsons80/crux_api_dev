package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.builder.ProgramaTOBuilder;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.entity.Projeto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosProjetoRule;
import br.com.crux.to.ProjetoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarProjetoCmd {

	@Autowired private ProjetoRepository repository;
	@Autowired private CamposObrigatoriosProjetoRule camposObrigatoriosRule;
	
	@Autowired private ProgramaTOBuilder programaTOBuilder;
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(ProjetoTO to) {
		Optional<Projeto> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Projeto informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataPrevisaoInicio());
		
		Projeto entityUpdate = entityOptional.get();

		entityUpdate.setNome(to.getNome());
		entityUpdate.setDescricao(to.getDescricao());
		
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());
		entityUpdate.setDataPrevisaoInicio(to.getDataPrevisaoInicio());
		entityUpdate.setDataPrevisaoTermino(to.getDataPrevisaoTermino());

		entityUpdate.setIniciativa(iniciativaTOBuilder.build(to.getIniciativa()));
		entityUpdate.setPrograma(programaTOBuilder.build(to.getPrograma()));
		
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entityUpdate);
		
	}
}
