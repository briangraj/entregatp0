package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion {

	private String id;
	private String title;
	private String description;
	private List<Nota> grades;
	
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public List<Nota> getGrades() {
		return grades;
	}
	
	public String getNotaActual(){
		if (this.grades.isEmpty()){
			return "";
		}
		return this.ultimaNota();
	}
	
	private String ultimaNota(){
		return Collections.max(this.grades, Comparator.comparing(grade -> grade.getUpdated_at())).getValue();

	}
	public String getEstadoNota(){
		String value = this.getNotaActual();
		
		if(value.equals("")) return "";
		
		if(value.matches("[0-9]")) {
			if(Integer.parseInt(value) >= 6) return "Aprobado";
		} 
		else if(value.startsWith("B") || value.startsWith("R")){
			return "Aprobado";
		}
		return "Desaprobado";
	}
}
