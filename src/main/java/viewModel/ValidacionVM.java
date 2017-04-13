package viewModel;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.utils.Dependencies;
import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import model.Estudiante;

@Observable
public class ValidacionVM {

	private String token;
	private String estado;
	private Estudiante estudiante = new Estudiante();

	
	public void validar(){
		this.cargarEstudiante();
		if (this.estudianteValido()) {
			this.estado = "Token v�lido";
		} else {
			this.estado = "Token inv�lido";
		}
	}
	
	private Boolean estudianteValido() {
		return  !this.estudiante.getCode().equals(null) &&
				!this.estudiante.getFirst_name().equals(null) &&
				!this.estudiante.getLast_name().equals(null) &&
				!this.estudiante.getGithub_user().equals(null);
	}
	
	//@Dependencies("token")
	public void cargarEstudiante(){
		String json = Client.create().resource("http://notitas.herokuapp.com")
			        		.path("student")
			        	 	.header("Authorization", "Bearer " + this.token)
			                .accept(MediaType.APPLICATION_JSON)
			                .get(ClientResponse.class)
			                .getEntity(String.class);
		this.estudiante = new Gson().fromJson(json, Estudiante.class);
	}
	
	public void accion(){
		
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
}
