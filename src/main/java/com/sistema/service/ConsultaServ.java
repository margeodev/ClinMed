package com.sistema.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sistema.model.Consulta;
import com.sistema.repository.Consultas;
import com.sistema.util.jpa.Transactional;

public class ConsultaServ implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Consultas consultaRep;
	
	@Transactional
	public void salvar(Consulta consulta){
		consultaRep.guardar(consulta);
	}
	
}