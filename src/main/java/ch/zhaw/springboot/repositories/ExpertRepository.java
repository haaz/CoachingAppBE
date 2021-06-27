package ch.zhaw.springboot.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Expert;


public interface ExpertRepository extends JpaRepository <Expert, Long>{

	@Query(value = "SELECT e.name FROM expert e, coaching c WHERE e.id = c.expert_id AND datediff(c.date, ?1) = 0",
			nativeQuery = true)
	public List<String> getExpertNameByCoachingDate(String date);
	

}
