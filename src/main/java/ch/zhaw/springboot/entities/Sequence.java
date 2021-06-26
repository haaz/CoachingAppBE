package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Sequence extends Experience {

	private int duration;

	public Sequence() {
		super();
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private Experience experience;

	public Sequence(String name, int duration) {
		super(name);
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}



}
