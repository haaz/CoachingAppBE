package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long>{

}
