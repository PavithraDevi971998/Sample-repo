package com.springreactive.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springreactive.bms.dao.LoanRepository;
import com.springreactive.bms.domain.Loan;
import com.springreactive.bms.domain.Register;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LoanController {
	
	@Autowired
	LoanRepository loanRepository;
	
	@PostMapping("/loan")
	//@ResponseStatus(HttpStatus.CREATED)
	public Mono<Loan> loandetails(@RequestBody Loan loan){
		
		return loanRepository.save(loan);
	}
	
	@GetMapping(path="/loan/username/{username}")
	public Mono<Loan> logincheck(@PathVariable String username ){
		return loanRepository.findByUsername(username);}

	/*
	 * Flux<Loan> result= loanRepository.findByUsername(username); return
	 * result.map(user->{ return result; }).defaultIfEmpty("user not found");
	 * 
	 * }
	 */
	/*
	 * @GetMapping(path="/loan/username/{username}") public
	 * Mono<ResponseEntity<Loan>> getloan(@PathVariable String username) { return
	 * loanRepository.findByUsername(username) .map((loan)->new
	 * ResponseEntity<>(loan,HttpStatus.OK)) .defaultIfEmpty(new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */
	@GetMapping("/loan/findall")
	public Flux<Loan> loanvalues()
	{
		
		return loanRepository.findAll();
	}
}
