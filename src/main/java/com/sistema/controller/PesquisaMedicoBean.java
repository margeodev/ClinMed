package com.sistema.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.model.Medico;
import com.sistema.repository.Medicos;
import com.sistema.repository.filter.MedicoFilter;

@Named("pmb")
@SessionScoped
public class PesquisaMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicos medicosRep;
	
	private List<Medico> medicos;
	private MedicoFilter medFilter = new MedicoFilter();

	@PostConstruct
	public void init(){
		medicos = medicosRep.todos();
	}
		
	public void pesquisar(){		
		medicos = medicosRep.filtrar(medFilter);
		System.out.println("Total de médicos: " + medicos.size());
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public MedicoFilter getMedFilter() {
		return medFilter;
	}
	
}
