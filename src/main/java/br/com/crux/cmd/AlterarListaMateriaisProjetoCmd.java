package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProjetoTOBuilder;
import br.com.crux.builder.ParceriasProjetoTOBuilder;
import br.com.crux.dao.repository.MateriaisProjetoRepository;
import br.com.crux.entity.MateriaisProjeto;
import br.com.crux.entity.ParceriasProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.MateriaisProjetoTO;
import br.com.crux.to.ParceriasProjetoTO;

@Component
public class AlterarListaMateriaisProjetoCmd {

	//TODO Fazer as RULES
	//@Autowired private CamposObrigatoriosParceriasProjetoRule camposObrigatoriosParceriasProjetoRule;

	@Autowired private MateriaisProjetoTOBuilder materiaisProjetoTOBuilder;
	@Autowired private MateriaisProjetoRepository materiaisProjetoRepository;
	@Autowired private ParceriasProjetoTOBuilder parceriasProjetoTOBuilder;
	@Autowired private GetParceriasProjetoCmd getParceriasProjetoCmd;
	@Autowired private CadastrarParceriaProjetoCmd cadastrarParceriaProjetoCmd;

	
	public void alterarAll(ParceriasProjeto parceriasProjeto, List<MateriaisProjetoTO> list, Projeto projeto) {

		// Lista da unidades que o usuário tem acesso.
		List<MateriaisProjeto> listaMateriaisProjeto = materiaisProjetoRepository.findByProjeto(projeto).orElse(new ArrayList<MateriaisProjeto>());

		BiPredicate<MateriaisProjeto, List<MateriaisProjetoTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(jaTinha -> Objects.nonNull(jaTinha.getId()) && jaTinha.getId() == nova.getId());

//		// Remove da lista todos os registros que não contém no Banco de Dados
//		listaMateriaisProjeto.removeIf(registro -> {
//			if (!contemNaLista.test(registro, list)) {
//				materiaisProjetoRepository.delete(registro);
//				return true;
//			}
//			return false;
//		});

		// Adiciona os novos registros
		List<MateriaisProjetoTO> novos = list.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(parceriasProjeto,projeto,novo));
		}

	}

	private void alterar(ParceriasProjeto parceriasProjeto, Projeto projeto, MateriaisProjetoTO novo) {
		//camposObrigatoriosParceriasProjetoRule.verificar(novo);
		MateriaisProjeto entity = materiaisProjetoTOBuilder.build(projeto,parceriasProjeto, novo);
		materiaisProjetoRepository.save(entity);
	}

	

	public void alterarListaMateriasParceiros(List<ParceriasProjetoTO> parceriasProjeto, Projeto projeto) {
		
		parceriasProjeto.forEach(pp -> {
			ParceriasProjeto build;
			if(Objects.isNull(pp.getId())) {
				build = cadastrarParceriaProjetoCmd.cadastrar(projeto, pp);
				pp.setId(build.getId());
			}else {
				build = getParceriasProjetoCmd.get(pp.getId());
			}
			alterarAll(build,pp.getMateriaisProjeto(), projeto);
		});
		
	}

}
