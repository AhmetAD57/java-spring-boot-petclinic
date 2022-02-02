package com.springproject;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicConfiguration {
	@Autowired
	private PetClinicProperties petClinicProperties;
	
	//Live cycle callback method
	//Spring Container tarafından ilgili sınıftan bir nesne oluşturulup bağımlılıkları enjekte edildikten sonra otomatik olarak invoke edilirler.
	@PostConstruct
	public void init() {
		System.out.println("Display owners with pets: " + petClinicProperties.isDisplayOwnersWithPets());
	}
}
