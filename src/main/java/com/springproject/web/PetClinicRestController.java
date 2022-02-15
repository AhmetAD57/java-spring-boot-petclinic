package com.springproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.exception.OwnerNotFoundException;
import com.springproject.model.Owner;
import com.springproject.service.PetClinicService;

@RestController //Kullanıldığında metotlara(Handler metotları) @ResponseBody koymaya gerek kalmıyor. @Controller yerine kullanılıyor.
//@Controller Class ın bir controller beani olduğu belirtilir. Metotlara @ResponseBody koyulması gerekiyor.

@RequestMapping("/rest")//Gelen web istekleri buradan karşılanıyor.(istek algılanıyor). Class seviyesinde kullanıldığında handler metotlarının @RequestMapping lerine ilgili prefixi(/rest) koymamıza gerek kalmıyor, hepsine koyulmuş gibi çalışıyor.

//@ResponseBody//Spring MVC Metot return değerini http message converterlar ile bir text(xml, json) messsage a çevirir. @Controller ile kullanılır.
public class PetClinicRestController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/owners") //HTTP request metotu belirtiliyor, request URL si belirtiliyor.
	public ResponseEntity<List<Owner>> getOwners(){
		List<Owner> owners = petClinicService.findOwners();
		return ResponseEntity.ok(owners); //Response body sine istenen veriler veriliyor ve responsa işlemin başarılı olduğu bilgiside konuluyor(http status code:200).  
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/owner")
	public ResponseEntity<List<Owner>> getOwners(@RequestParam("ln") String lastname){ //@RequestParam("ln") request URL sinde ln parametresiindeki değeri lastName e akarmayuı sağlıyor.(/owner?ln=Cook)
		List<Owner> owners = petClinicService.findOwners(lastname);
		return ResponseEntity.ok(owners); 
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/owner/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){ //@PathVariable("id") request URL sinde /owner/ dan sonta gelen değeri id ye aktarıyor.(/owner/5  id=5)
		try {
			Owner owner = petClinicService.findOwner(id);
			return ResponseEntity.ok(owner); 
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.notFound().build();  // istenilen requestin sunucuda olmadığının beliritor. (status code: 404)
		}
		
		
		
	}
	
	
	
}
