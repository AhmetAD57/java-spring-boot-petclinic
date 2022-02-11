package com.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//Spring boot  PetClinicProperties den bean oluşturur ve yapılan konfigurasyonları class dan algılar
@EnableConfigurationProperties(value=PetClinicProperties.class)
public class PetClinicApplication {
	public static void main(String[] args) throws Exception{
		//Uygulma buradan çalıştırılıyor
		SpringApplication.run(PetClinicApplication.class, args);
	}
}