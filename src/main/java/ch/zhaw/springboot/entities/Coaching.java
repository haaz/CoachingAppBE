package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String date;
	private String country;
	private String city;

	@JsonIgnore
	@ManyToOne
	private Expert expert;

	@JsonIgnore
	@ManyToOne
	private Experience experience;

	public Coaching(String date, String country, String city, Expert expert, Experience experience) {
		this.date = date;
		this.country = country;
		this.city = city;
		this.expert = expert;
		this.experience = experience;
	}

	public long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public Expert getExpert() {
		return expert;
	}

	public Experience getExperience() {
		return experience;
	}
	
	
	

}
