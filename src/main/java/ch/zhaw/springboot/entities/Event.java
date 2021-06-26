package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Event extends Experience {

	private String description;

	public Event() {
		super();
	}
	

	public Event(String name, String description) {
		super(name);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}


}
