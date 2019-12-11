package com.springboot.personalCredit.document;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="personalCredit")
public class PersonalCredit {
	
	@Id
	private String id;
	
	@NotBlank
	private String creditAmount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCredit;
	 
	@NotBlank
	private Double tea;
	
	@NotBlank
	private int cantShare;

}
