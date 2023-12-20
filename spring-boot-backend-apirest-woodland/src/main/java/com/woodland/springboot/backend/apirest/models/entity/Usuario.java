package com.woodland.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombreTutor;
	@Column (nullable=false, unique=true)
	private String emailTutor;
	
	@Column(nullable=false)
	private String nombreNinyo;
	
	@Column (nullable=false, unique=true)
	private String emailNinyo;
	
	private String tarea1;
	private String tarea2;
	private String tarea3;
	private String tarea4;
	private String tarea5;
	
	private String tareaExtra1;
	private String tareaExtra2;
	//@Column(name ="create_at")
	//@Temporal(TemporalType.DATE)
	//private Date createAt;
	//@PrePersist
	//public void prePersist() {
	//    createAt = new Date(System.currentTimeMillis());
	//}
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombreTutor() {
		return nombreTutor;
	}



	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}



	public String getEmailTutor() {
		return emailTutor;
	}



	public void setEmailTutor(String emailTutor) {
		this.emailTutor = emailTutor;
	}



	public String getNombreNinyo() {
		return nombreNinyo;
	}



	public void setNombreNinyo(String nombreNinyo) {
		this.nombreNinyo = nombreNinyo;
	}



	public String getEmailNinyo() {
		return emailNinyo;
	}



	public void setEmailNinyo(String emailNinyo) {
		this.emailNinyo = emailNinyo;
	}



	public String getTarea1() {
		return tarea1;
	}



	public void setTarea1(String tarea1) {
		this.tarea1 = tarea1;
	}



	public String getTarea2() {
		return tarea2;
	}



	public void setTarea2(String tarea2) {
		this.tarea2 = tarea2;
	}



	public String getTarea3() {
		return tarea3;
	}



	public void setTarea3(String tarea3) {
		this.tarea3 = tarea3;
	}



	public String getTarea4() {
		return tarea4;
	}



	public void setTarea4(String tarea4) {
		this.tarea4 = tarea4;
	}



	public String getTarea5() {
		return tarea5;
	}



	public void setTarea5(String tarea5) {
		this.tarea5 = tarea5;
	}



	public String getTareaExtra1() {
		return tareaExtra1;
	}



	public void setTareaExtra1(String tareaExtra1) {
		this.tareaExtra1 = tareaExtra1;
	}



	public String getTareaExtra2() {
		return tareaExtra2;
	}



	public void setTareaExtra2(String tareaExtra2) {
		this.tareaExtra2 = tareaExtra2;
	}




}
	
	
	


