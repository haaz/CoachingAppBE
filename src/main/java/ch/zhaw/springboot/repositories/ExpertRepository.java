package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Expert;

public interface ExpertRepository extends JpaRepository <Expert, Long>{

}
