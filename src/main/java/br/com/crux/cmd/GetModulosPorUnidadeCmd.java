package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ModuloTOBuilder;
import br.com.crux.dao.ModuloDao;
import br.com.crux.exception.ParametroNaoInformado;
import br.com.crux.to.ModuloTO;

@Component
public class GetModulosPorUnidadeCmd {

	@Autowired private ModuloDao moduloDao;
	@Autowired private ModuloTOBuilder moduloTOBuilder;
	
	public List<ModuloTO> getModulosPorUnidade(Long idUnidade) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformado("Erro ao recuperar os módulos. Parâmetro 'unidade' ausente.");
		}
		return moduloTOBuilder.buildAll(moduloDao.getModuloPorUnidade(idUnidade));
	}
}
