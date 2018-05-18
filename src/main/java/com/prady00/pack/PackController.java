package com.prady00.pack;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packs")
public class PackController {
	
	@Autowired	
	PackRepository packRepository;
	
	@PostMapping("/")
	public Pack createPack(@Valid @RequestBody Pack pack){
		// todo check if there is already a pack of the user
		// todo allow only 20 hits per hour per IP application wide
		// send email to the user 
		// generate tests and save pack
		// send back success
		return packRepository.save(pack);
	}

}
