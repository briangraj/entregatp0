package viewModel;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import model.Estudiante;

@Observable
public class ValidacionVM {

	private String token;
	private String estado = "Ingrese token";
	private Boolean habilitarOpciones;
	private Boolean cambiarToken = true;
	private Estudiante estudiante;
	
	public void validar(){
		this.cargarEstudiante();
		if (this.estudianteValido()) {
			this.estado = "Token valido";
			this.habilitarOpciones = true;
			this.cambiarToken = null;
		} else {
			this.estado = "Token invalido";
			this.habilitarOpciones = null;
			this.cambiarToken = true;
		}
	}
	
	public void habilitarIngresarToken(){
		this.estado = "Ingrese token";
		this.habilitarOpciones = null;
		this.cambiarToken = true;
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
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEstado() {
		return estado;
	}

	public Boolean getHabilitarOpciones() {
		return habilitarOpciones;
	}

	public Boolean getCambiarToken() {
		return cambiarToken;
	}

	public ValidacionVM getViewModel() {
		return this;
	}
}
