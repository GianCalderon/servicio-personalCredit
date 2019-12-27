package com.springboot.personalCredit.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalCreditImpl.class);
	
	@Autowired
	PersonalCreditRepo repo;
	
	@Autowired
	UtilConvert convert;
	
	@Autowired
	PersonalClient client;
	
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
	    return repo.findById(id).flatMap(credito -> {

	    
	        
	        credito.setTea(personalCredit.getTea());
	        credito.setCantShare(personalCredit.getCantShare());
	        credito.setDateUpdate(new Date());
	        
	        return repo.save(credito);

	      });
	}

	@Override
	public Mono<Void> delete(PersonalCredit personalCredit) {
		// TODO Auto-generated method stub
		return repo.delete(personalCredit);
	}

	@Override
	public Mono<PersonalCreditDto> saveDto(PersonalCreditDto personalCreditDto) {
		
		LOGGER.info("service:"+personalCreditDto.toString());

		return repo.save(convert.convertPersonalCredit(personalCreditDto)).flatMap(sa -> {
			client.save(personalCreditDto.getHeadline()).block();
			
			personalCreditDto.setIdPersonalCredit(sa.getId());
			
			return Mono.just(personalCreditDto);
		});
	
	}



		
	}


