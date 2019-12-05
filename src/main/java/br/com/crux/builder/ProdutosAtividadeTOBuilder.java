package br.com.crux.builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetAtividadeCmd;
import br.com.crux.cmd.GetMaterialCmd;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.entity.Material;
import br.com.crux.enums.FormaPagamento;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class ProdutosAtividadeTOBuilder {

	@Autowired
	private AtividadesTOBuilder atividadeBuilder;
	@Autowired
	private MaterialTOBuilder materialBuilder;
	@Autowired
	private GetAtividadeCmd getAtividadeCmd;
	@Autowired
	private GetMaterialCmd getMaterialCmd;

	public MateriaisAtividade build(MateriaisAtividadeTO p) {
		MateriaisAtividade retorno = new MateriaisAtividade();

		BeanUtils.copyProperties(p, retorno);

		Optional.ofNullable(p.getFormaPagamento()).ifPresent(tipo -> {
			retorno.setFormaPagamento(FormaPagamento.getPorTipo(tipo));
		});

		Optional.ofNullable(p.getAtividade()).ifPresent(atividade -> {
			Atividades a = getAtividadeCmd.getById(atividade.getId());
			retorno.setAtividade(a);
		});

		Optional.ofNullable(p.getMaterial()).ifPresent(material -> {
			Material mat = getMaterialCmd.getById(material.getId());
			retorno.setMaterial(mat);
		});

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public MateriaisAtividadeTO buildTO(MateriaisAtividade p) {
		MateriaisAtividadeTO retorno = new MateriaisAtividadeTO();

		BeanUtils.copyProperties(p, retorno);

		Optional.ofNullable(p.getFormaPagamento()).ifPresent(formaPagamento -> {
			retorno.setFormaPagamento(formaPagamento.getTipo());
		});

		retorno.setAtividade(atividadeBuilder.buildTO(p.getAtividade()));
		retorno.setMaterial(materialBuilder.buildTO(p.getMaterial()));

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<MateriaisAtividadeTO> buildAll(List<MateriaisAtividade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
