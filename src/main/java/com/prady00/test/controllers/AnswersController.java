package com.prady00.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prady00.test.repositories.AnswersRepository;

@RestController
@RequestMapping("/answers")
public class AnswersController {
	
	@Autowired
	AnswersRepository answersRepo;

}
