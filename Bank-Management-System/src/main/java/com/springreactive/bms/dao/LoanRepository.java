package com.springreactive.bms.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springreactive.bms.domain.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface LoanRepository extends ReactiveMongoRepository<Loan,String> {

	Mono<Loan> findByUsername(String username);

}
