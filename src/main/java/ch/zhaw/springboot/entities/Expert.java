package ch.zhaw.springboot.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;



@Entity
public class Expert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy="expert")
	private List<Coaching> coachings;

	private String name;
	@Lob
	private String about;
	private String email;
	private String phone;

	public Expert(String name, String about, String email, String phone) {
		this.name = name;
		this.about = about;
		this.email = email;
		this.phone = phone;
	}
	
	public Expert () {
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbout() {
		return about;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}




}
