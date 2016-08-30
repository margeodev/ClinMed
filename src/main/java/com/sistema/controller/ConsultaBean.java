package com.sistema.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.sistema.model.Consulta;
import com.sistema.model.Medico;
import com.sistema.model.Paciente;
import com.sistema.repository.Consultas;
import com.sistema.repository.Medicos;
import com.sistema.repository.Pacientes;
import com.sistema.repository.filter.PacienteFilter;
import com.sistema.service.ConsultaServ;
import com.sistema.service.NegocioException;
import com.sistema.util.jsf.FacesUtil;

@Named("consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsultaServ consultaServ;
	
	@Inject
	private Consultas consultaRep;
	
	@Inject
	private Pacientes pacRep;
	
	@Inject
	private Medicos medRep;
	
	private List<Consulta> consultas;
	private PacienteFilter pacienteFilter = new PacienteFilter();
	private List<Paciente> pacientes; 
	private Consulta consulta;	
	private Paciente paciente;	
	private List<Medico> medicos;	
	
	@PostConstruct
	public void init(){
		pacientes = pacRep.ultimos();
		paciente = new Paciente();
		consulta = new Consulta();
		medicos = medRep.todos();
		consultas = consultaRep.todas();
	}
	
	public void onRowSelect(SelectEvent event) {		
		consulta.setPaciente((Paciente)event.getObject());
    }

	public void buscar(){		
		if (pacienteFilter.getNome().length()>2){
			pacientes = pacRep.filtrar(pacienteFilter);
		}		
	}
	
	public void atualizar(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome: " + pacienteFilter.getNome()));
	}	
	
	public List<Medico> escolherMedico(String input) {
        List<Medico> medicosSugeridos = new ArrayList<>();      
        
        for (Medico med : medicos) {
            if (med.getNome().toLowerCase().startsWith(input.toLowerCase())) {
            	medicosSugeridos.add(med);
            }
        }        
        return medicosSugeridos;
	}	
	
	public void registrar(){
		try {
			consultaServ.salvar(consulta);
			FacesUtil.addSuccessMessage("Consulta registrada com sucesso!");
			init();
		} catch (NegocioException e) {			
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
		
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public PacienteFilter getPacienteFilter() {
		return pacienteFilter;
	}

	public void setPacienteFilter(PacienteFilter pacienteFilter) {
		this.pacienteFilter = pacienteFilter;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}
	
}
