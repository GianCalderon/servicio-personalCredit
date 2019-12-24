package com.springboot.personalCredit.service;

import com.springboot.personalCredit.document.PersonalCredit;
import com.springboot.personalCredit.dto.PersonalCreditDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalCreditInterface {

	  public Flux<PersonalCredit> findAll();
	  
	  public Mono<PersonalCredit> findById(String id);
	  
	  public Mono<PersonalCredit> save(PersonalCredit personalCredit);
	  
	  public Mono<PersonalCredit> update(PersonalCredit personalCredit,String id);
	  
	  public Mono<Void> delete(PersonalCredit enterpriseCredit);
	  
	  public Mono<PersonalCredit> saveDto(PersonalCreditDto personalCreditDto);



	
}
