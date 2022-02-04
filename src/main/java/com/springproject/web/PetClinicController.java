package com.springproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//Spring conteiner bir controller bean i oluşturuyor. Metotlardaki request maping anatosyonlarının tarayarak gelen web isteklerini ilgili metotlarla eşleştirir.
public class PetClinicController {
	@RequestMapping("/pcs")
	@ResponseBody//View olarak döndürülmesini önlemek için kullanılır
	public String welcome() { //Handler metot
		return "Welcome to pet clinic";
	}

}
