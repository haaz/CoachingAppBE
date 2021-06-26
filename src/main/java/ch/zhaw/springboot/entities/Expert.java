package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String about;
	private String email;
	private String phone;

	public Expert(String name, String about, String email, String phone) {
		this.name = name;
		this.about = about;
		this.email = email;
		this.phone = phone;
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
