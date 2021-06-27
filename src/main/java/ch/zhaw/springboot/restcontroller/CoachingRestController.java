package ch.zhaw.springboot.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Coaching;

import ch.zhaw.springboot.repositories.CoachingRepository;

@RestController
@CrossOrigin
public class CoachingRestController {

	@Autowired
	private CoachingRepository repository;

	
	@GetMapping("coachingapp/coachings")
	public ResponseEntity<List<Coaching>> getCoachings() {
		List<Coaching> result = repository.findAll();
		if (!result.isEmpty()) {

			return new ResponseEntity<List<Coaching>>(result, HttpStatus.OK);
		} else {

			return new ResponseEntity<List<Coaching>>(HttpStatus.NOT_FOUND);
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
	
	
	@GetMapping("coachingapp/coachings/getCoachingsByCountry/{country}")
	public ResponseEntity<List<Coaching>> getCoachingsByCountry(@PathVariable("country") String country) {
		List<Coaching> result = this.repository.getCoachingsByCountry(country);
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Coaching>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Coaching>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("coachingapp/coachings/getCoachingsByCity/{city}")
	public ResponseEntity<List<Coaching>> getCoachingsByCity(@PathVariable("city") String city) {
		List<Coaching> result = this.repository.getCoachingsByCity(city);
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<Coaching>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Coaching>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "coachingapp/coachings/{id}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteCoachingById(@PathVariable(value = "id") Long coachingId) {
		Optional<Coaching> coaching = repository.findById(coachingId);

		if (coaching.isPresent()) {
			repository.deleteById(coachingId);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;

		} else {
			Map<String, Boolean> response = new HashMap<>();
			response.put("Coaching not found for this id", Boolean.FALSE);
			return response;
		}
	}

}
