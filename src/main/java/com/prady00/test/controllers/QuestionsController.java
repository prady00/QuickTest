package com.prady00.test.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prady00.test.models.Questions;
import com.prady00.test.repositories.QuestionsRepository;
import com.prady00.test.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	@Autowired
	QuestionsRepository questionsRepo;
	
	@GetMapping("/")
	public List<Questions> getQuestions(){
		return questionsRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Questions getAQuestion(@PathVariable(value = "id") Long id) {
	    return questionsRepo.findById(id)
	    		.orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
	}
	
	@PostMapping("/")
    public Questions createQuestion(@Valid @RequestBody Questions question) {
        return questionsRepo.save(question);
    }

    @PutMapping("/{id}")
    public Questions updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Questions newQuestion) {

        Questions question = questionsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));

        question.setTitle(newQuestion.getTitle());
        question.setDescription(newQuestion.getDescription());
        
        Questions updatedQuestion = questionsRepo.save(question);
        return updatedQuestion;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        Questions question = questionsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));

        questionsRepo.delete(question);

        return ResponseEntity.ok().build();
    }

}
