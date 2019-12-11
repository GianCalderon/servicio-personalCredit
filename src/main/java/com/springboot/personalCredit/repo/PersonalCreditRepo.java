package com.springboot.personalCredit.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.personalCredit.document.PersonalCredit;

public interface PersonalCreditRepo extends ReactiveMongoRepository<PersonalCredit, String> {

}
