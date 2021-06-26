package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.zhaw.springboot.entities.Coaching;
import ch.zhaw.springboot.repositories.CoachingRepository;

public class CoachingRestController {

	@Autowired
	private CoachingRepository repository;

	@GetMapping("coachingapp/coachings")
	public ResponseEntity<List<Coaching>> getCoachings() {
		List<Coaching> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("coachingapp/coachings/{id}")
	public ResponseEntity<Coaching> getCoachingById(@PathVariable("id") Long id) {
		Optional<Coaching> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Coaching>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Coaching>(HttpStatus.NOT_FOUND);
		}
	}

}
