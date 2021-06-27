package ch.zhaw.springboot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;




@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	@OneToMany(mappedBy="experience")
	private List<Coaching> coachings;
	

	@OneToMany(mappedBy="experience")
	private List<Sequence> sequences;

	public Experience(Sequence parent, String name) {

		this.name = name;

	}
	
	public Experience() {
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}



}
