package br.com.crux.cmd;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ResponsaveisAlunoRepository;
import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.enums.TipoResponsavel;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosResponsaveisAlunoRule;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class AlterarResponsaveisAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private ResponsaveisAlunoRepository repository;
	@Autowired private CamposObrigatoriosResponsaveisAlunoRule camposObrigatoriosRule;

	public ResponsaveisAluno alterar(ResponsaveisAlunoTO to) {
		Optional<ResponsaveisAluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Responsavel do Aluno informada não existe.");
		}
		camposObrigatoriosRule.verificar(to);
		
		ResponsaveisAluno entity = entityOptional.get();

		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setDescGrauParentesco(to.getDescGrauParentesco());
		entity.setDataDesvinculacao(to.getDataDesvinculacao());
		entity.setDataVinculacao(to.getDataVinculacao());
		entity.setMesmoEnderResponsavel(to.getMesmoEnderResponsavel());
		entity.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		if(StringUtils.isNotEmpty(to.getTipoResponsavel())) {
			TipoResponsavel tipoResponsavel = TipoResponsavel.getPorTipo(to.getTipoResponsavel());
			entity.setTipoResponsavel(tipoResponsavel);
		}
	
		return repository.save(entity);
		
	}
}
