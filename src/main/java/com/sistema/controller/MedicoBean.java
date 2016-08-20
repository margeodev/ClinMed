package com.sistema.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Endereco;
import com.sistema.modelo.Especialidade;
import com.sistema.modelo.Medico;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.repository.Especialidades;
import com.sistema.repository.Medicos;
import com.sistema.util.jsf.FacesUtil;

@Named("mb")
@RequestScoped
public class MedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Medico medico;
	@Inject
	private Medicos medicos;
	@Inject
	private EnderecoPorCep endCep;
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();
	@Inject
	private Especialidades espRep;
	
	@PostConstruct
	public void init() {
		limpar();	
	}	
	
	public void adicionar() {
		medicos.guardar(medico);
		FacesUtil.addSuccessMessage("Médico adicionado com sucesso.");
		limpar();
	}

	public void limpar(){
		medico = new Medico();		
		medico.setEndereco(new Endereco());
		especialidades = espRep.especialidades();
		System.out.println("novo medico");
	}
		
	public void fillAddress() {
		medico.setEndereco(endCep.obterEndereco(medico.getEndereco().getCep()));
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

}
