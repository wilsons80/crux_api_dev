package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.EmpresaTOBuilder;
import br.com.crux.dao.repository.EmpresaRepository;
import br.com.crux.entity.Empresa;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosEmpresaRule;
import br.com.crux.to.EmpresaTO;

@Component
public class AlterarEmpresaCmd {

	@Autowired private EmpresaRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosEmpresaRule camposObrigatoriosRule;
	@Autowired private EmpresaTOBuilder empresaTOBuilder;
	
	public Empresa alterar(EmpresaTO to) {
		Optional<Empresa> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Empresa informada não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getCodigo(), to.getNomeRazaoSocial(), to.getTipoEmpresa(), to.getTelefone(), to.getEndereco());
		
		Empresa entity = empresaTOBuilder.build(to);
		entity.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		Empresa empresaSalva = repository.save(entity);
		
		return empresaSalva;
		
	}
}
