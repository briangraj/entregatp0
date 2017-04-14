package viewModel;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import model.Estudiante;

@Observable
public class ValidacionVM extends ParentVM{

	//private String token;
	private String estado;
	private Boolean habilitarOpciones;
	private Estudiante estudiante;
	
	public void validar(){
		this.cargarEstudiante();
		if (this.estudianteValido()) {
			this.estado = "Token v�lido";
			this.habilitarOpciones = true;
		} else {
			this.estado = "Token inv�lido";
			this.habilitarOpciones = null;
		}
	}
	
	private Boolean estudianteValido() {
		return  this.estudiante.getCode() != null &&
				this.estudiante.getFirst_name() != null &&
				this.estudiante.getLast_name() != null &&
				this.estudiante.getGithub_user() != null;
	}
	
	public void cargarEstudiante(){
		String json = Client.create().resource("http://notitas.herokuapp.com")
			        		.path("student")
			        	 	.header("Authorization", "Bearer " + this.token)
			                .accept(MediaType.APPLICATION_JSON)
			                .get(ClientResponse.class)
			                .getEntity(String.class);
		this.estudiante = new Gson().fromJson(json, Estudiante.class);
	}
	/*
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}*/

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getHabilitarOpciones() {
		return habilitarOpciones;
	}

	/*public void setHabilitarOpciones(Boolean habilitarOpciones) {
		this.habilitarOpciones = habilitarOpciones;
	}*/


}
