package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.DepartamentoTOBuilder;
import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.DepartamentoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Departamentos;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosDepartamentoRule;
import br.com.crux.to.DepartamentoTO;

@Component
public class CadastrarDepartamentoCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private DepartamentoRepository departamentoRepository;
	@Autowired private DepartamentoTOBuilder departamentoTOBuilder;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosDepartamentoRule camposObrigatoriosDepartamentoRule;
	
	public void cadastrar(DepartamentoTO to) {
		
		
		Optional<Unidade> unidade = unidadeRepository.findById(to.getUnidade().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		
		camposObrigatoriosDepartamentoRule.verificar(to.getCdUnidadeDepartamento(), to.getNmDepartamento(), to.getUnidade().getIdUnidade());
				
		if(Objects.nonNull(to.getDepartamentoSuperior())) {
			Optional<Departamentos> departamento = departamentoRepository.findById(to.getDepartamentoSuperior().getIdDepartamento());
			if(!departamento.isPresent()) {
				throw new NotFoundException("Departamento superior não existe.");
			}
		}
		

		
		Departamentos departamento = new Departamentos();

		departamento.setCdUnidadeDepartamento(to.getCdUnidadeDepartamento());
		departamento.setDsEnderecoDepartamento(to.getDsEnderecoDepartamento());
		departamento.setNmDepartamento(to.getNmDepartamento());
		departamento.setNrTelefoneDepartamento(to.getNrTelefoneDepartamento());
		departamento.setUnidade(unidadeBuilder.build(to.getUnidade()));
		
		if(Objects.nonNull(to.getDepartamentoSuperior())) {
			departamento.setDepartamentosSuperior(departamentoTOBuilder.build(to.getDepartamentoSuperior()));
		}
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		departamento.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		departamentoRepository.save(departamento);
		
	}
}
