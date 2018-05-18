package com.prady00.question;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prady00.exceptions.ResourceNotFoundException;

public class QuestionController {
	
	@Autowired
	QuestionRepository questionsRepo;
	
	@GetMapping("/")
	public List<Question> getQuestions(){
		return questionsRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Question getAQuestion(@PathVariable(value = "id") Long id) {
	    return questionsRepo.findById(id)
	    		.orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
	}
	
	@PostMapping("/")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionsRepo.save(question);
    }

    @PutMapping("/{id}")
    public Question updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Question newQuestion) {

        Question question = questionsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));

        question.setTitle(newQuestion.getTitle());
        question.setDescription(newQuestion.getDescription());
        
        Question updatedQuestion = questionsRepo.save(question);
        return updatedQuestion;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        Question question = questionsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));

        questionsRepo.delete(question);

        return ResponseEntity.ok().build();
    }

}
