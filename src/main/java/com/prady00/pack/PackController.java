package com.prady00.pack;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prady00.exceptions.UserAlreadyRequestedPack;
import com.prady00.test.Test;
import com.prady00.test.TestRepository;

@RestController
@RequestMapping("/packs")
public class PackController {
	
	@Autowired	
	PackRepository packRepository;
	@Autowired
	TestRepository testRepository;
	
	@PostMapping("/")
	public Pack createPack(@RequestBody Pack pack) throws UserAlreadyRequestedPack{
		
		// check if there is already a pack of the user
		List<Pack> packs = packRepository.findAllByEmail(pack.getEmail());
		
		if(packs.size() > 0){
			throw new UserAlreadyRequestedPack("User is not allowed to request more than one pack");
		}
		// todo allow only 20 hits per hour per IP application wide
		
		// save pack
		packRepository.save(pack);
		
		List<Test> generatedTest = new ArrayList<>();
		
		// generate tests and save them
		for(int i = 0; i<3;i++){
			Test test = new Test();
			test.setPack_id(pack.getId());
			test.setNumber_of_questions(30);
			test.setSlug((String.valueOf(System.currentTimeMillis())));
			testRepository.save(test);
			generatedTest.add(test);
		}
		
		// send email to the user 
			
		// send back success
		return packRepository.save(pack);
	}

}
