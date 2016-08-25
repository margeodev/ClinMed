package com.sistema.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Medico;
import com.sistema.repository.Medicos;
import com.sistema.repository.filter.MedicoFilter;

@Named("pmb")
@SessionScoped
public class PesquisaMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicos medicosRep;
	
	private List<Medico> medicos;
	private MedicoFilter medFilter;
		
	public PesquisaMedicoBean(){		
		medFilter = new MedicoFilter();
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
