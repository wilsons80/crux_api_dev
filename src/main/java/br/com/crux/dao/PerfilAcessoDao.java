package br.com.crux.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dto.AcessoDTO;

@Component
public class PerfilAcessoDao  {
	
	@Autowired 
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<AcessoDTO> getAcesso(Long idUsarname, Long idUnidade) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("	select us.id_usuario as idUsuario,                              ");
		sql.append("	   us.nm_username as userName,                                  ");
		sql.append("       u.cd_unidade as cdUnidade,                                   ");
		sql.append("       m.nm_modulo as nomeModulo,                                   ");
		sql.append("       pa.cs_altera as altera,                                      ");
		sql.append("       pa.cs_consulta as consulta,                                  ");
		sql.append("       pa.cs_deleta as deleta,                                      ");
		sql.append("       pa.cs_insere as insere                                       ");
		sql.append("  from usuarios_grupos ug,                                          ");
		sql.append("       usuarios_sistema us,                                         ");
		sql.append("       modulos m,                                                   ");
		sql.append("       grupos_modulos gm,                                           ");
		sql.append("       unidades u,                                                  ");
		sql.append("       usuarios_unidades uu,                                        ");
		sql.append("       perfis_acessos pa                                            ");
		sql.append(" where ug.id_grupo_modulo  = gm.id_grupo_modulo                     ");
		sql.append("   and gm.id_modulo        = m.id_modulo                            ");
		sql.append("   and ug.id_usuario       = us.id_usuario                          ");
		sql.append("   and us.id_usuario       = uu.id_usuario                          ");
		sql.append("   and uu.id_unidade       = u.id_unidade                           ");
		sql.append("   and gm.id_unidade       = u.id_unidade                           ");
		sql.append("   and pa.id_perfil_acesso = gm.id_perfil_acesso                    ");
		sql.append("   and u.id_unidade        = :idUnidade                             ");
		sql.append("   and us.id_usuario       = :idUsarname                            ");
		
		
		
		Query query = em.createNativeQuery(sql.toString());
		query.setParameter("idUsarname", idUsarname);
		query.setParameter("idUnidade", idUnidade);
		
		List<Object[]> values = query.getResultList();
		
		List<AcessoDTO> retorno = new ArrayList<AcessoDTO>();
		values.stream().forEach( colunas -> retorno.add(new AcessoDTO(colunas)));
		
		return retorno;
	}
	

}
