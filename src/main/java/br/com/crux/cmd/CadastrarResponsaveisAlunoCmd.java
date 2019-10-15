package br.com.crux.cmd;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ResponsaveisAlunoRepository;
import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.enums.TipoResponsavel;
import br.com.crux.rule.CamposObrigatoriosResponsaveisAlunoRule;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class CadastrarResponsaveisAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ResponsaveisAlunoRepository repository;
	@Autowired private CamposObrigatoriosResponsaveisAlunoRule camposObrigatoriosRule;

	public ResponsaveisAluno cadastrar(ResponsaveisAlunoTO to) {
		camposObrigatoriosRule.verificar(to);
		
		ResponsaveisAluno entity = new ResponsaveisAluno();
		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setDescGrauParentesco(to.getDescGrauParentesco());
		entity.setDataDesvinculacao(to.getDataDesvinculacao());
		entity.setDataVinculacao(to.getDataVinculacao());
		entity.setMesmoEnderResponsavel(to.getMesmoEnderResponsavel());
		entity.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		if(StringUtils.isNotEmpty(to.getTipoResponsavel())) {
			entity.setTipoResponsavel(TipoResponsavel.getPorTipo(to.getTipoResponsavel()));
		}
		
		return repository.save(entity);
	
	}
}
