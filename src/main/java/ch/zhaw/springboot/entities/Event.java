package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.Lob;



@Entity
public class Event extends Experience {
	@Lob
	private String description;

	public Event(Sequence parent, String name, String description) {
		super(parent, name);
		this.description = description;
	}

	public Event() {

	}

	public String getDescription() {
		return description;
	}

}
