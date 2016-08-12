package com.sistema.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.modelo.Medico;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.repository.Medicos;

@Named("mb")
@RequestScoped
public class MedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Medico medico;
	@Inject
	private Medicos medicos;
	@Inject
	private EnderecoPorCep endCep;

	public MedicoBean() {
		medico = new Medico();
	}

	public void adicionar() {
		medicos.guardar(medico);
	}

	// Preenche o atributo endereco do objeto medico com o objeto endereco
	// retornado do metodo obterEndereco()
	public void fillAddress() {
		medico.setEndereco(endCep.obterEndereco(medico.getEndereco().getCep()));
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
