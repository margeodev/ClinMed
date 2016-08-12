package com.sistema.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sistema.modelo.Paciente;

public class Pacientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Paciente paciente) {
		EntityTransaction trx = em.getTransaction();
		trx.begin();		
		paciente = em.merge(paciente);		
		trx.commit();
		System.out.println("Paciente adicionado.");
		
	}
	
}
