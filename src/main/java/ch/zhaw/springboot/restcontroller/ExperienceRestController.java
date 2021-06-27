package ch.zhaw.springboot.restcontroller;

import java.util.List;
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


import ch.zhaw.springboot.entities.Experience;
import ch.zhaw.springboot.repositories.ExperienceRepository;

@RestController
@CrossOrigin
public class ExperienceRestController {
	@Autowired
	private ExperienceRepository repository;


	@RequestMapping(value = "coachingapp/experiences", method = RequestMethod.GET)
	public ResponseEntity<List<Experience>> getExperiences() {
		List<Experience> result = repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Experience>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Experience>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("coachingapp/experiences/{id}")
	public ResponseEntity<Experience> getExperienceById(@PathVariable("id") Long id) {
		Optional<Experience> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Experience>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "coachingapp/experiences/findExperienceByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Experience>> findExperienceByName(@PathVariable("name") String name) {
		List<Experience> result = this.repository.findExperienceByName(name);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Experience>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Experience>>(HttpStatus.NOT_FOUND);
		}
	}

}
