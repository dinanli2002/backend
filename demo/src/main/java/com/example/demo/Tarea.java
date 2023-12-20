package com.example.demo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the tareas database table.
 * 
 */
@Entity
@Table(name="tareas")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtareas;

	private int moneda;

	private String nombredetareas;

	public Tarea() {
	}

	public int getIdtareas() {
		return this.idtareas;
	}

	public void setIdtareas(int idtareas) {
		this.idtareas = idtareas;
	}

	public int getMoneda() {
		return this.moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public String getNombredetareas() {
		return this.nombredetareas;
	}

	public void setNombredetareas(String nombredetareas) {
		this.nombredetareas = nombredetareas;
	}

}