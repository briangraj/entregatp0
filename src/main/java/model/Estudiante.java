package model;

public class Estudiante {

	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	public Estudiante(){
		super();
	}
	
	public Estudiante(String code, String first_name, String last_name, String github_user){
		this.code = code;
		this.first_name = first_name;
		this.last_name = last_name;
		this.github_user = github_user;
	}
	
	public String getCode() {
		return code;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getGithub_user() {
		return github_user;
	}
}
