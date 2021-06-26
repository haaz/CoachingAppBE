package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.zhaw.springboot.entities.Experience;
import ch.zhaw.springboot.repositories.ExperienceRepository;

public class ExperienceRestController {
	@Autowired
	private ExperienceRepository repository;

	@GetMapping("coachingapp/experience")
	public ResponseEntity<List<Experience>> getExperiences() {
		List<Experience> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("coachingapp/experience/{id}")
	public ResponseEntity<Experience> getExperienceById(@PathVariable("id") Long id) {
		Optional<Experience> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Experience>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
		}
	}

}
