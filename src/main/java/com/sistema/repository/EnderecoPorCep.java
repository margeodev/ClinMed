package com.sistema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sistema.modelo.Endereco;

public class EnderecoPorCep implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	public Endereco obterEndereco(String cep){
		String sql = "SELECT * FROM cep_pb where cep=:cep";
		Query query = em.createNativeQuery(sql).setParameter("cep", cep);
		List<Object[]> list = query.getResultList();
		Endereco endereco = new Endereco();
		if (list.size()>0){
			Object[] obj = list.get(0);			
			String cidade = (String) obj[1];
			String logradouro = (String) obj[2];
			String bairro = (String) obj[3];
			String _cep = (String) obj[4];
			String estado = (String) obj[6];
			endereco.setCidade(cidade);
			endereco.setLogradouro(logradouro);
			endereco.setBairro(bairro);
			endereco.setCep(_cep);
			endereco.setEstado(estado);
		} else {
			endereco.setCep(cep);
		}		
		return endereco;
	}
	
	

}
