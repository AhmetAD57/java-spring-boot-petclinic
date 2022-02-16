package com.springproject.petclinic.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springproject.model.Owner;

import ch.qos.logback.core.boolex.Matcher;

public class PetClinicRestControllerTest {
	
	private RestTemplate restTemplate;
	
	@Before // Test metotları çalışmadan önce çalışır.
	public void setUp() {
		restTemplate = new RestTemplate();
	}
	
	@Test //Junit test anatasyonu kullanılması gerek
	public void testGetOwnerById() {
		ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class); //Owner.class response un body sinin owner tipinde olduğu belirtiliyor.
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200)); //Response un başarılı bir şekilde geldiği kontrol ediliyor.
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Cafer"));
	}
	
	@Test //Junit test anatasyonu kullanılması gerek
	public void testGetOwnerByLastName() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Cook", List.class); //List.class response un body sinin List tipinde olduğu belirtiliyor.
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200)); //Response un başarılı bir şekilde geldiği kontrol ediliyor.
		
		List<Map<String, String>> body = response.getBody();
		List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Rock", "Tim", "Cafer"));
	}
	
	@Test //Junit test anatasyonu kullanılması gerek
	public void testGetOwners() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class); //List.class response un body sinin List tipinde olduğu belirtiliyor.
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200)); //Response un başarılı bir şekilde geldiği kontrol ediliyor.
		
		List<Map<String, String>> body = response.getBody();
		List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Rock", "Tim", "Cafer"));
	}

}
