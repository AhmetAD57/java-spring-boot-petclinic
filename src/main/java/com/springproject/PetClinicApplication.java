package com.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //Custom servlet yada filter kullanıldığında uygulamanınalılaya bilmesi için kullanılır(WebServlet, WebFilter tespit ediliyor)
@SpringBootApplication
//Spring boot  PetClinicProperties den bean oluşturur ve yapılan konfigurasyonları class dan algılar
@EnableConfigurationProperties(value=PetClinicProperties.class)
public class PetClinicApplication {
	public static void main(String[] args) throws Exception{
		//Uygulma buradan çalıştırılıyor
		SpringApplication.run(PetClinicApplication.class, args);
	}
}