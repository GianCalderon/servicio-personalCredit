package com.springboot.personalCredit.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.personalCredit.document.PersonalCredit;
import com.springboot.personalCredit.service.PersonalCreditInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personalCredit")
public class EnterpriseCreditController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseCreditController.class);


	  @Autowired
	 PersonalCreditInterface service;

	  @GetMapping
	  public Mono<ResponseEntity<Flux< PersonalCredit>>> toList() {

	    return Mono.just(ResponseEntity.ok()
	          .contentType(MediaType.APPLICATION_JSON).body(service.findAll()));

	  }

	  @GetMapping("/{id}")
	  public Mono<ResponseEntity< PersonalCredit>> search(@PathVariable String id) {

	    return service.findById(id).map(e -> ResponseEntity.ok()
	      .contentType(MediaType.APPLICATION_JSON).body(e))
	      .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @PostMapping
	  public Mono<ResponseEntity<PersonalCredit>> save(@RequestBody  PersonalCredit  personalCredit) {


	    return service.save(personalCredit).map(e -> ResponseEntity.created(URI.create("/api/personalCredit"))
	                  .contentType(MediaType.APPLICATION_JSON).body(e));

	  }

	  @PutMapping("/{id}")
	  public Mono<ResponseEntity<PersonalCredit>> update(@RequestBody PersonalCredit personalCredit,
	                    @PathVariable String id) {

	    return service.update(personalCredit, id)
	             .map(p -> ResponseEntity.created(URI.create("/api/personalCredit".concat(p.getId())))
	             .contentType(MediaType.APPLICATION_JSON).body(p))
	             .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @DeleteMapping("/{id}")
	  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

	    return service.findById(id).flatMap(p -> {
	      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
	    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

	  }
	  

}
