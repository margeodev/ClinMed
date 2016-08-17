package com.sistema.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Medico;
import com.sistema.repository.Medicos;

@Named("pmb")
public class PesquisaMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicos medicosRep;
	private List<Medico> medicos = new ArrayList<>();
	private Medico medico;
	
	@PostConstruct
	public void init(){
		medicos = medicosRep.buscarTodos();
	}
		
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}
	
}
