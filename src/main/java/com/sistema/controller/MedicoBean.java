package com.sistema.controller;

import java.io.Serializable;

import com.sistema.modelo.Medico;

public class MedicoBean implements Serializable{
	private Medico medico;

	
	public MedicoBean(){
		medico = new Medico();
	}
	
	
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
}
