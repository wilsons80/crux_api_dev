package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.builder.ProgramaTOBuilder;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.entity.Projeto;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosProjetoRule;
import br.com.crux.to.ProjetoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarProjetoCmd {

	@Autowired private ProjetoRepository repository;
	
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder; 
	@Autowired private ProgramaTOBuilder programaTOBuilder;
	
	@Autowired private CamposObrigatoriosProjetoRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(ProjetoTO to) {
		
		if(Objects.isNull(to.getIniciativa())) {
			throw new ParametroNaoInformadoException("Iniciativa não foi informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataPrevisaoInicio());
		
		Projeto entity = new Projeto();

		entity.setNome(to.getNome());
		entity.setDescricao(to.getDescricao());
		
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		entity.setDataPrevisaoInicio(to.getDataPrevisaoInicio());
		entity.setDataPrevisaoTermino(to.getDataPrevisaoTermino());

		if(Objects.nonNull(to.getIniciativa())) {
			entity.setIniciativa(iniciativaTOBuilder.build(to.getIniciativa()));
		}
		
		if(Objects.nonNull(to.getPrograma())) {
			entity.setPrograma(programaTOBuilder.build(to.getPrograma()));
		}
		
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
