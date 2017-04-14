package model;

import org.joda.time.DateTime;

public class Nota {

	private String id;
	private String value;
	private String created_at;
	private String updated_at;
	
	
	public String getId() {
		return id;
	}
	public String getValue() {
		return value;
	}
	public DateTime getCreated_at() {
		return DateTime.parse(this.created_at);
	}
	public DateTime getUpdated_at() {
		return DateTime.parse(this.updated_at);
	}
	
	
}
