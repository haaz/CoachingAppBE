package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ch.zhaw.springboot.entities.Expert;

import ch.zhaw.springboot.models.ExpertRequest;
import ch.zhaw.springboot.repositories.ExpertRepository;

@RestController
@CrossOrigin
public class ExpertRestController {
	@Autowired
	private ExpertRepository repository;

	@RequestMapping(value = "coachingapp/experts", method = RequestMethod.GET)
	public ResponseEntity<List<Expert>> getExperts() {
		List<Expert> result = repository.findAll();

		if (!result.isEmpty()) {

			return new ResponseEntity<List<Expert>>(result, HttpStatus.OK);
		} else {

			return new ResponseEntity<List<Expert>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("coachingapp/experts/{id}")
	public ResponseEntity<Expert> getExpertById(@PathVariable("id") Long id) {
		Optional<Expert> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Expert>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Expert>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value = "coachingapp/experts/getExpertNameByCoachingDate/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getExpertNameByCoachingDate(@PathVariable("date") String genre) {
		List<String> result = this.repository.getExpertNameByCoachingDate(genre);
		
		if (!result.isEmpty()) {
			return new ResponseEntity<List<String>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "coachingapp/experts", method = RequestMethod.POST)
	public ResponseEntity<Expert> createExpert(@RequestBody ExpertRequest expertRequest) {
		try {
			Expert expert = new Expert(expertRequest.name, expertRequest.about, expertRequest.email, expertRequest.phone);
			Expert result = this.repository.save(expert);
			return new ResponseEntity<Expert>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Expert>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
