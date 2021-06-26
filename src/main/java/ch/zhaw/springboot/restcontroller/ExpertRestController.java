package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.zhaw.springboot.entities.Expert;
import ch.zhaw.springboot.repositories.ExpertRepository;

public class ExpertRestController {
	@Autowired
	private ExpertRepository repository;

	@GetMapping("coachingapp/experience")
	public ResponseEntity<List<Expert>> getExperts() {
		List<Expert> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("coachingapp/experience/{id}")
	public ResponseEntity<Expert> getExpertById(@PathVariable("id") Long id) {
		Optional<Expert> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Expert>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Expert>(HttpStatus.NOT_FOUND);
		}
	}
}
