package com.sistema.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sistema.modelo.Medico;

public class Medicos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Medico medico) {
		EntityTransaction trx = em.getTransaction();
		trx.begin();		
		medico = em.merge(medico);		
		trx.commit();
		System.out.println("Medico adicionado.");
		
	}
	
}
