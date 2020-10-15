package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//creamos user JPA entity
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_user;
	
	@Column(name = "tipoUser")
	private String tipoUser;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_time")
	private String firstTime;
	
	@Column(name = "pregunta_seguridad")
	private String preguntaSeguridad;
	
	@Column(name = "respuesta_seguridad")
	private String respuestaSeguridad;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;
	
	@Column(name = "celular")
	private String celular;

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getSexo() {
		return sexo;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getCelular() {
		return celular;
	}

	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id_user + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", firstTime=" + firstTime
				+ ", preguntaSeguridad=" + preguntaSeguridad + ", respuestaSeguridad=" + respuestaSeguridad + ", sexo="
				+ sexo + ", tipoIdentificacion=" + tipoIdentificacion + ", numeroIdentificacion=" + numeroIdentificacion
				+ ", celular=" + celular + "]";
	}

	public User(String firstName, String lastName, String email, String username, String password, String firstTime,
			String preguntaSeguridad, String respuestaSeguridad, String sexo, String tipoIdentificacion,
			String numeroIdentificacion, String celular, String tipoUser) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstTime = firstTime;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
		this.sexo = sexo;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.celular = celular;
		this.tipoUser = tipoUser;
	}

	public String isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id_user;
	}
	public void setId(long id_user) {
		this.id_user = id_user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	public String getFirstTime() {
		return firstTime;
	}
}
