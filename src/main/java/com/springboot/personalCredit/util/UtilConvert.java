package com.springboot.personalCredit.util;

import org.springframework.stereotype.Component;

import com.springboot.personalCredit.document.PersonalCredit;
import com.springboot.personalCredit.dto.PersonalCreditDto;

@Component
public class UtilConvert {
	
	
	public PersonalCredit convertPersonalCredit(PersonalCreditDto personalCreditDto) {

		PersonalCredit personalCredit = new PersonalCredit();

		personalCredit.setName("Credito-Personal");
		personalCredit.setCreditAmount(personalCreditDto.getCreditAmount());
		personalCredit.setDateCredit(personalCreditDto.getDateCredit());
		personalCredit.setTea(personalCreditDto.getTea());
		personalCredit.setCantShare(personalCreditDto.getCantShare());
		
		return personalCredit;

	}


}
