package com.springboot.personalCredit.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonalCreditDto {
	
	
	@NotBlank
	private String creditAmount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCredit;
	 
	@NotBlank
	private Double tea;
	
	@NotBlank
	private int cantShare;
	
	private PersonalDto holders;

	
	
}
