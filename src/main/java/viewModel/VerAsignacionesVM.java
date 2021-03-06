package viewModel;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import model.Asignacion;
import model.Asignaciones;

@Observable
public class VerAsignacionesVM {
	
	private List<Asignacion> asignaciones;
	private String token;
	
	
	public void cargarNotas() {
		String json = Client.create().resource("http://notitas.herokuapp.com")
			        		.path("student/assignments")
			        	 	.header("Authorization", "Bearer " + this.token)
			                .accept(MediaType.APPLICATION_JSON)
			                .get(ClientResponse.class)
			                .getEntity(String.class);
		
		this.asignaciones = new Gson().fromJson(json, Asignaciones.class).getAssignments();
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
