package com.sistema.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.sistema.model.Paciente;
import com.sistema.repository.Pacientes;
import com.sistema.repository.filter.PacienteFilter;

@Named("ppb")
@SessionScoped
public class PesquisaPacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pacientes pacRep;
	
	private List<Paciente> pacientes;
	private PacienteFilter pacFilter = new PacienteFilter();
	
	@PostConstruct
	public void init(){
		pacientes = pacRep.todos();
	}
	
	public void pesquisar(){		
		pacientes = pacRep.filtrar(pacFilter);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public PacienteFilter getPacFilter() {
		return pacFilter;
	}	
	
}
