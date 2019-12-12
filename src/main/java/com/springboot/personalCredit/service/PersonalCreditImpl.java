package com.springboot.personalCredit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.personalCredit.client.PersonalClient;
import com.springboot.personalCredit.document.PersonalCredit;
import com.springboot.personalCredit.dto.PersonalCreditDto;
import com.springboot.personalCredit.repo.PersonalCreditRepo;
import com.springboot.personalCredit.util.UtilConvert;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalCreditImpl implements PersonalCreditInterface {

	@Autowired
	PersonalCreditRepo repo;
	
	@Autowired
	UtilConvert convert;
	
	@Autowired
	PersonalClient webCLient;
	
	@Override
	public Flux<PersonalCredit> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mono<PersonalCredit> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Mono<PersonalCredit> save(PersonalCredit personalCredit) {
		// TODO Auto-generated method stub
		return repo.save(personalCredit);
	}

	@Override
	public Mono<PersonalCredit> update(PersonalCredit personalCredit, String id) {
		// TODO Auto-generated method stub
	    return repo.findById(id).flatMap(p -> {

	    	p.setCreditAmount(personalCredit.getCreditAmount());
	        p.setDateCredit(personalCredit.getDateCredit());
	        p.setTea(personalCredit.getTea());
	        
	        return repo.save(p);

	      });
	}

	@Override
	public Mono<Void> delete(PersonalCredit personalCredit) {
		// TODO Auto-generated method stub
		return repo.delete(personalCredit);
	}

	@Override
	public Mono<PersonalCreditDto> saveDto(PersonalCreditDto personalCreditDto) {
		
		return save(convert.convertPersonalCredit(personalCreditDto)).flatMap(sa -> {

			personalCreditDto.getHolders().setIdCuenta(sa.getId());
			webCLient.save(personalCreditDto.getHolders()).block();
			

			return Mono.just(personalCreditDto);
		});
		
		
	}



		
	}


