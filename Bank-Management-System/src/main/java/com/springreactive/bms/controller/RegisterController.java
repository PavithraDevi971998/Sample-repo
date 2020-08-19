package com.springreactive.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springreactive.bms.dao.BmsRepository;
import com.springreactive.bms.domain.Loan;
import com.springreactive.bms.domain.Register;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RegisterController {
	
	@Autowired
	BmsRepository bmsRepository;
	
	@PostMapping("/bms")
	//@ResponseStatus(HttpStatus.CREATED)
	public Mono<Register> registerCustomer(@RequestBody Register register){
		
		return bmsRepository.save(register);
	}
	
	@GetMapping(path="/bms/username/{username}/password/{password}")
	public Mono<String> logincheck(@PathVariable String username,@PathVariable String password ){
		
		 Mono<Register> result = bmsRepository.findByUsernameAndPassword(username,password);
		
				return result.map(user->{
					return "user logged in successfully";
				}).defaultIfEmpty("user not found");
		
	}
	@PostMapping(path="/bms/login")
	public Mono<String> logincheckdemo(@RequestBody Register register ){
		
		String username=register.getUsername();
		String password=register.getPassword();
		 Mono<Register> result = bmsRepository.findByUsernameAndPassword(username,password);
		
				return result.map(user->{
					return "user logged in successfully";
				}).defaultIfEmpty("user not found");
		
	}
	
       


	@PutMapping("/bms/{id}")
	public Mono<ResponseEntity<String>> updatedetails(@PathVariable int id,@RequestBody Register register){
		 return bmsRepository.findById(id)
	                .flatMap(currentItem -> {

	                    currentItem.setAddress(register.getAddress());
	                    currentItem.setEmail(register.getEmail());
	                    currentItem.setContactno(register.getContactno());
	                    return bmsRepository.save(currentItem);
	                })
	                .map(updatedItem -> new ResponseEntity<>("Details updated successfully", HttpStatus.OK)).log()
              .defaultIfEmpty(new ResponseEntity<>("update failed user not found",HttpStatus.NOT_FOUND)).log();
//	                .map(updatedItem -> new ResponseEntity<>(updatedItem, HttpStatus.OK))
//	                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND)).log();
	}
	@GetMapping("/customer/findall")
	public Flux<Register> customervalues()
	{
		
		
		return bmsRepository.findAll();
	}
}
