package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Coaching;

public interface CoachingRepository extends JpaRepository<Coaching, Long> {

}
