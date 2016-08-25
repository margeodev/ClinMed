package com.sistema.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Medico;
import com.sistema.modelo.Paciente;
import com.sistema.repository.Medicos;
import com.sistema.repository.Pacientes;
import com.sistema.repository.filter.MedicoFilter;
import com.sistema.repository.filter.PacienteFilter;

@Named("ppb")
@SessionScoped
public class PesquisaPacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pacientes pacRep;
	
	private List<Paciente> pacientes;
	private PacienteFilter pacFilter;
		
	public PesquisaPacienteBean(){		
		pacFilter = new PacienteFilter();
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
