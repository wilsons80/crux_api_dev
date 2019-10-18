package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Instituicao;
import br.com.crux.to.InstituicaoTO;

@Component
public class InstituicaoTOBuilder {

	public Instituicao build(InstituicaoTO to) {
		Instituicao retorno = new Instituicao();

		retorno.setId(to.getId());
		retorno.setNome(to.getNome());
		retorno.setIdArquivo(to.getIdArquivo());
		retorno.setUsuarioAlteracao(to.getUsuarioAlteracao());
		retorno.setMostraLista(to.getMostraLista());

		return retorno;
	}

	public InstituicaoTO buildTO(Instituicao to) {
		InstituicaoTO retorno = new InstituicaoTO();

		if (Objects.isNull(to)) {
			return retorno;
		}

		retorno.setId(to.getId());
		retorno.setNome(to.getNome());
		retorno.setIdArquivo(to.getIdArquivo());
		retorno.setUsuarioAlteracao(to.getUsuarioAlteracao());
		retorno.setMostraLista(to.getMostraLista());
		
		return retorno;
	}

	public List<InstituicaoTO> buildAllTO(List<Instituicao> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
