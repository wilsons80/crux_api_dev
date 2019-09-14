package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.EmpresaRepository;
import br.com.crux.entity.Empresa;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosEmpresaRule;
import br.com.crux.to.EmpresaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarEmpresaCmd {

	@Autowired private EmpresaRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosEmpresaRule camposObrigatoriosRule;
	
	
	public void alterar(EmpresaTO to) {
		Optional<Empresa> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Empresa informada não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getCodigo(), to.getNomeRazaoSocial(), to.getTipoEmpresa(), to.getTelefone(), to.getEndereco());
		
		Empresa entity = entityOptional.get();
		
		entity.setCodigo(to.getCodigo());
		entity.setNomeFantasia(to.getNomeFantasia());
		entity.setNomeRazaoSocial(to.getNomeRazaoSocial());
		entity.setCnpj(to.getCnpj());
		entity.setInscricaoEstadual(to.getInscricaoEstadual());
		entity.setInscricaoMunicipal(to.getInscricaoMunicipal());
		entity.setAtiva(to.getAtiva());
		entity.setTipoEmpresa(to.getTipoEmpresa());
		entity.setValorIcms(to.getValorIcms());
		entity.setDescricaoCategoriaEmpresa(to.getDescricaoCategoriaEmpresa());
		entity.setDescricaoTipoEmpresa(to.getDescricaoTipoEmpresa());
		entity.setCategoriaEmpresa(to.getCategoriaEmpresa());	
		entity.setTelefone(to.getTelefone());
		entity.setEmail(to.getEmail());
		entity.setAutorizaEmail(to.getAutorizaEmail());
		entity.setHomePage(to.getHomePage());
		entity.setEndereco(to.getEndereco());
		entity.setBairro(to.getBairro());
		entity.setCidade(to.getCidade());
		entity.setCep(to.getCep());
		entity.setUf(to.getUf());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
