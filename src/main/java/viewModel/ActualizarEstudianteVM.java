package viewModel;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import model.Estudiante;

@Observable
public class ActualizarEstudianteVM {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;

	private String token;
	private String regex = "^[a-zA-Z ]+$";
	
	public void verificarDatos(){
		if(!this.datosLlenados()) {
			throw new UserException("Debe llenar algun dato");
		}
		if(this.first_name != null) verificarCampo(this.first_name);
		if(this.last_name != null) verificarCampo(this.last_name);
		this.actualizarDatos();
		
	}
	
	public void verificarCampo(String campo){
		if(!campo.matches(this.regex)){
			throw new UserException("Nombre y apellido solo pueden tener letras");
		}
	}
	
	public Boolean datosLlenados(){
		return this.last_name != null ||
				this.first_name != null ||
				this.github_user != null ||
				this.code != null;
	}
	
	public void actualizarDatos(){
		Estudiante estudiante = new Estudiante(code, first_name, last_name, github_user);
		String json = new Gson().toJson(estudiante);
		
		Client.create().resource("http://notitas.herokuapp.com")
        		.path("student")
        	 	.header("Authorization", "Bearer " + this.token)
                .accept(MediaType.APPLICATION_JSON)
                .put(ClientResponse.class, json);
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGithub_user() {
		return github_user;
	}

	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
