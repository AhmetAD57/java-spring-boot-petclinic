package com.springproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.service.PetClinicService;

@Controller//Spring conteiner bir controller bean i oluşturuyor. Metotlardaki request maping anatosyonlarının tarayarak gelen web isteklerini ilgili metotlarla eşleştirir.
public class PetClinicController {
	
	
	@Autowired //bootstarp sırasında PetClinicService tipindeki bean i PetClinicController beanine enjekte edecek
	private PetClinicService petClinicService;
	
	//Böyle bir istk geldiğinde getOwners() çalışacak
	@RequestMapping("/owners")
	public ModelAndView getOwners() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("owners", petClinicService.findOwners());
		mav.setViewName("owners");
		return mav;
	}
	
	
	
	@RequestMapping("/pcs")
	@ResponseBody//View olarak döndürülmesini önlemek için kullanılır
	public String welcome() { //Handler metot
		return "Welcome to pet clinic.";
	}

}
