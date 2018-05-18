package com.prady00.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class AnswerController {
	
	@Autowired
	AnswerRepository answersRepo;

}
