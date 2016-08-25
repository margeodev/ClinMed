package com.sistema.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Paciente;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.service.NegocioException;
import com.sistema.service.PacServ;
import com.sistema.util.jsf.FacesUtil;

@Named("pb")
@RequestScoped
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Paciente paciente;
	@Inject
	private PacServ pacServ;
	@Inject
	private EnderecoPorCep endCep;

	public PacienteBean() {
		limpar();
	}

	public void limpar(){
		paciente = new Paciente();
	}
	
	public void adicionar() {
		try {
			pacServ.salvar(paciente);
			FacesUtil.addSuccessMessage("Paciente adicionado com sucesso.");
			limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}		
	}
	
	public Date getDataHoje(){
		return new Date(); 
	}
	
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
