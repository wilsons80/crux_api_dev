package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.PerfilAcessoRepository;
import br.com.crux.entity.PerfisAcesso;

@Component
public class GetPerfilAcessoCmd {

	@Autowired
	private PerfilAcessoRepository perfilAcessoRepository;

	public List<PerfisAcesso> getAllPerfilAcesso() {
		return perfilAcessoRepository.findAll();

	}

}
