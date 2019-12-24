package com.springboot.personalCredit.document;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(collection="personalCredit")
public class PersonalCredit {
	
	@Id
	private String id;
	
	@NotNull(message = "User's nameCredit must not be null")
	private String nameCredit;
	
	@NotNull(message = "User's numDoc must not be null")
	private String numDoc;
	
	@NotNull(message = "User's creditAmount must not be null")
	private Double creditAmount;
	
	@NotNull(message = "User's tea must not be null")
	@Min(20) 
	@Max(30)
	private Double tea;
	
	@NotNull(message = "User's cantShare must not be null")
	@Min(12) //  Numero min de cuotas
	@Max(36)// Numero max de cuotas
	private int cantShare;

	@NotNull(message = "User's amountShare must not be null")
	private Double amountShare ;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateCreate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateUpdate;
	

}
