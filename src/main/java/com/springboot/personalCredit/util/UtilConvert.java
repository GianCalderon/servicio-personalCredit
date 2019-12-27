package com.springboot.personalCredit.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.personalCredit.document.PersonalCredit;
import com.springboot.personalCredit.dto.PersonalCreditDto;

@Component
public class UtilConvert {
	
	
	public PersonalCredit convertPersonalCredit(PersonalCreditDto personalCreditDto) {

		PersonalCredit personalCredit = new PersonalCredit();

		personalCredit.setNameCredit("Credito-Personal");
		personalCredit.setNumDoc(personalCreditDto.getHeadline().getNumDoc());
		personalCredit.setCreditAmount(personalCreditDto.getCreditAmount());
		personalCredit.setTea(personalCreditDto.getTea());
		personalCredit.setCantShare(personalCreditDto.getCantShare());
		personalCredit.setAmountShare((personalCreditDto.getCreditAmount()+
				                      (personalCreditDto.getCreditAmount()*(personalCreditDto.getTea()/100)))
				                      /personalCreditDto.getCantShare());
		
		personalCredit.setDateCreate(new Date());
		personalCredit.setDateUpdate(new Date());
		
		
		
		return personalCredit;

	}


}
