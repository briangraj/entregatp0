package viewModel;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;

import model.Estudiante;

@Observable
public class ActualizarEstudianteVM {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;

	private String token;
	private String regex = "^[a-zA-Z]+$";
	
	public void verificarDatos(){
		//this.actualizarDatos();
		if(!this.datosLlenados()) {
			throw new UserException("Debe completar todos los datos");
		}
		
		if(!first_name.matches(this.regex)){
			throw new UserException("El nombre solo puede tener letras");
		} else if(!last_name.matches(this.regex)) {
			throw new UserException("El apellido solo puede tener letras");
		}else {
			this.actualizarDatos();
		}
	}
	
	public Boolean datosLlenados(){
		return this.last_name != null &&
				this.first_name != null &&
				this.github_user != null;
	}
	
	public void actualizarDatos(){
		Estudiante estudiante = new Estudiante(code, first_name, last_name, github_user);
		String json = new Gson().toJson(estudiante, Estudiante.class);//.toJson(estudiante);
		
		Client.create().resource("http://notitas.herokuapp.com")
        		.path("student")
        	 	.header("Authorization", "Bearer " + this.token)
                .accept(MediaType.APPLICATION_JSON)
                .put(json);//.put(json, ClientResponse.class)
                //.put(ClientResponse.class, json);
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
