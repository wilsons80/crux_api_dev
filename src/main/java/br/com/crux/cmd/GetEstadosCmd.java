package br.com.crux.cmd;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.crux.enums.Estados;

@Component
public class GetEstadosCmd {

	
	public List<Estados> getAllEstados() {
		Estados[] values = Estados.values();
		return Arrays.asList(values);
	}
}
