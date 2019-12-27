package com.springboot.personalCredit.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonalCreditDto {

	private String idPersonalCredit;
	
	private Double creditAmount;
	private Double tea;
	private int cantShare;
	private PersonalDto headline;

	
	
}
