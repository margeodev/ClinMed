package com.sistema.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Paciente;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.repository.Pacientes;

@Named("pb")
@RequestScoped
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	@Inject
	private Pacientes pacientes;
	@Inject
	private EnderecoPorCep endCep;

	public PacienteBean() {
		limpar();
	}

	public void limpar(){
		paciente = new Paciente();
	}
	
	public void adicionar() {
		pacientes.guardar(paciente);
		limpar();
		
	}
	
	public Date getDataHoje(){
		return new Date(); 
	}

	// Preenche o atributo endereco do objeto medico com o objeto endereco
	// retornado do metodo obterEndereco()
	public void fillAddress() {
		paciente.setEndereco(endCep.obterEndereco(paciente.getEndereco().getCep()));
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setMedico(Paciente paciente) {
		this.paciente = paciente;
	}

}
