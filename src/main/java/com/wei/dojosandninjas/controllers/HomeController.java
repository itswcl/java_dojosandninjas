package com.wei.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wei.dojosandninjas.models.Dojo;
import com.wei.dojosandninjas.models.Ninja;
import com.wei.dojosandninjas.services.DojoService;
import com.wei.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {
	
	// inject both service MANY nad ONE
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	// test here and see if we link everything up
	@GetMapping("/")
	public String index() {
		return "test.jsp";
	}
	
	// NINJA READ ALL
	@GetMapping("/ninjas")
	public String allNinjas(Model model) {
		List<Ninja> allNinjas = ninjaService.displayNinjas();
		
		model.addAttribute(allNinjas);
		return "ninjas/show.jsp";
	}
	
	// DOJO CREATE
	// 1 - GET request to render create page
	@GetMapping("/dojos/new")
	public String createDojo(
			@Valid
			@ModelAttribute("dojo") Dojo dojo,
			BindingResult result
//			Model model
			) {
		if (result.hasErrors()) {
			
//			model.addAttribute("dojos", dojoService.displayDojos());
			return "/dojos/new";
		} else {

			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
		
	}
	
	// 2 - POST request to sent create service to SQL
}
