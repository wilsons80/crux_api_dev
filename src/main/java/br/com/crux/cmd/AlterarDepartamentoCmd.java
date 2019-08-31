package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.DepartamentoRepository;
import br.com.crux.entity.Departamentos;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosDepartamentoRule;
import br.com.crux.to.DepartamentoTO;

@Component
public class AlterarDepartamentoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private DepartamentoRepository departamentoRepository;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private CamposObrigatoriosDepartamentoRule camposObrigatoriosDepartamentoRule;
	
	
	public void alterar(DepartamentoTO to) {
		Optional<Departamentos> departamentoOptional = departamentoRepository.findById(to.getIdDepartamento());
		if(!departamentoOptional.isPresent()) {
			throw new NotFoundException("Departamento informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		
		camposObrigatoriosDepartamentoRule.verificar(to.getCdUnidadeDepartamento(), to.getNmDepartamento(), to.getUnidade().getIdUnidade());
		
		Departamentos departamentos = departamentoOptional.get();

		departamentos.setCdUnidadeDepartamento(to.getCdUnidadeDepartamento());
		departamentos.setDsEnderecoDepartamento(to.getDsEnderecoDepartamento());
		departamentos.setNmDepartamento(to.getNmDepartamento());
		departamentos.setNrTelefoneDepartamento(to.getNrTelefoneDepartamento());
		departamentos.setUnidade(unidadeBuilder.build(to.getUnidade()));
		
		if(Objects.nonNull(to.getDepartamentoSuperior().getIdDepartamento())) {
			Optional<Departamentos> departamentoSuperior = departamentoRepository.findById(to.getDepartamentoSuperior().getIdDepartamento());
			if(!departamentoSuperior.isPresent()) {
				throw new NotFoundException("Departamento Superior não encontrado.");
			}
			departamentos.setDepartamentosSuperior(departamentoSuperior.get());
		}
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		departamentos.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		departamentoRepository.save(departamentos);
		
	}
}
