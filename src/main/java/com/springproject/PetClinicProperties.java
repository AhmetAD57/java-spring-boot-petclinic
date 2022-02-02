package com.springproject;

import org.springframework.boot.context.properties.ConfigurationProperties;


//Proje konfigurasyonlarının java kodyla kullanabilmeyi sağlıyor.

//Anotasyon
//application.properties dosyasındaki tanımlar tanımlanan prefixe göre bulunup kullanılacak
@ConfigurationProperties(prefix = "petclinic")
public class PetClinicProperties {
	private boolean displayOwnersWithPets = false;
	
	public boolean isDisplayOwnersWithPets() {
		return displayOwnersWithPets;
	}
	
	public void setDisplayOwnersWithPets(boolean displayOwnersWithPets) {
		this.displayOwnersWithPets = displayOwnersWithPets;
	}

}
