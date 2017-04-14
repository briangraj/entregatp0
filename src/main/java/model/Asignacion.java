package model;

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
	
	
}
