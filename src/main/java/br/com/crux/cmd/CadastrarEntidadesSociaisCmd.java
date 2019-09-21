package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.EmpresaTOBuilder;
import br.com.crux.dao.repository.EmpresaRepository;
import br.com.crux.dao.repository.EntidadesSociaisRepository;
import br.com.crux.entity.Empresa;
import br.com.crux.entity.EntidadesSociais;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosEntidadesSociaisRule;
import br.com.crux.to.EntidadesSociaisTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarEntidadesSociaisCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private EntidadesSociaisRepository repository;
	@Autowired private CamposObrigatoriosEntidadesSociaisRule camposObrigatoriosRule;

	@Autowired private EmpresaRepository empresaRepository;
	@Autowired private EmpresaTOBuilder empresaBuilder;
	
	
	public void cadastrar(EntidadesSociaisTO to) {
		
		if(Objects.isNull(to.getEmpresa())) {
			throw new NotFoundException("Empresa não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getEmpresa().getId());
		
		Optional<Empresa> empresaOptional = empresaRepository.findById(to.getEmpresa().getId());
		if(!empresaOptional.isPresent()) {
			throw new NotFoundException("Empresa informado não existe.");
		}
		
		EntidadesSociais entity = new EntidadesSociais();

		entity.setDataFim(to.getDataFim());
		entity.setDataVinculo(to.getDataVinculo());
		entity.setEmpresa(empresaBuilder.build(to.getEmpresa()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);

		
	}
}
