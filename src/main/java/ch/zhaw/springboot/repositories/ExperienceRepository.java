package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ch.zhaw.springboot.entities.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long>{

	@Query("SELECT e FROM Experience e WHERE e.name like %?1% ORDER BY e.name DESC")
	public List<Experience> findExperienceByName(String name);
	
}
