package ch.zhaw.springboot.entities;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Sequence extends Experience {

	private int durationYears;
	
	@ManyToOne
	private Experience experience;

	public Sequence(Sequence parent, String name, int duration) {
		super(parent, name);
		this.durationYears = duration;

	}

	public Sequence() {

	}

	public int getDuration() {
		return durationYears;
	}

}
