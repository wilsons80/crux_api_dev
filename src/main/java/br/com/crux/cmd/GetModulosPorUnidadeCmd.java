package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ModuloTOBuilder;
import br.com.crux.dao.ModuloDao;
import br.com.crux.to.ModuloTO;

@Component
public class GetModulosPorUnidadeCmd {

	@Autowired private ModuloDao moduloDao;
	@Autowired private ModuloTOBuilder moduloTOBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<ModuloTO> getModulosPorUnidade() {
		
		return moduloTOBuilder.buildAll(moduloDao.getModuloPorUnidade(getUnidadeLogadaCmd.get().getId()));
	}
}
