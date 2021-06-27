package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Coaching;

public interface CoachingRepository extends JpaRepository<Coaching, Long> {

	@Query("SELECT c From Coaching c WHERE c.country = ?1")
	public List<Coaching> getCoachingsByCountry(String country);
	
	@Query("SELECT c From Coaching c WHERE c.city = ?1")
	public List<Coaching> getCoachingsByCity(String city);
	
}
