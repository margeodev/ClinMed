package com.sistema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.sistema.modelo.Medico;

public class Medicos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Medico medico) {
		em.merge(medico);			
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> buscarTodos(){
		return em.createQuery("from Medico").getResultList();
	}	

	public Medico porCRM(String crm) {
		try {
			return em.createQuery("from Medico where crm = :crm", Medico.class)
				.setParameter("crm", crm).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
