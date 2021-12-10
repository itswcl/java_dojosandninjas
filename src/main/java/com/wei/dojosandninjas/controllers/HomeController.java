package com.wei.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		return "redirect:/ninjas";
	}
	
	// NINJA READ ALL
	@GetMapping("/ninjas")
	public String allNinjas(Model model) {
		List<Ninja> ninjas = ninjaService.displayNinjas();
		model.addAttribute("ninjas", ninjas);
		
		
		List<Dojo> dojos = dojoService.displayDojos();
		model.addAttribute("dojos", dojos);
		
		return "ninjas/show.jsp";
	}
// --------- Ninja --------
	// NINJA CREATE
	// 1 - GET request to render create ninja new page
	@GetMapping("/ninjas/new")
	public String createNinjaDisplay(
			@ModelAttribute("ninja") Ninja ninja,
			Model model
			) {
		// call ninja's info
		model.addAttribute("ninjas", ninjaService.displayNinjas());
		// call dojo's info
		model.addAttribute("dojos", dojoService.displayDojos());
		return "/ninjas/new.jsp";
	}
	// NINJA CREATE
	// 2 - POST request to sent create service to ninjas table
	@PostMapping("/ninjas/new")
	public String createNinja(
			@Valid
			@ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			// remeber to re render the page element
			// only need to like selection
			model.addAttribute("dojos", dojoService.displayDojos());
			return "/ninjas/new.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	
// --------- DOJO ---------
	// DOJO CREATE
	// 1 - GET request to render create dojo new page
	@GetMapping("/dojos/new")
	public String createDojoDisplay(
			@ModelAttribute("dojo") Dojo dojo,
			Model model
			) {
			model.addAttribute("dojos", dojoService.displayDojos());
			
			return "/dojos/new.jsp";
		
	}
	
	// DOJO CREATE
	// 2 - POST request to sent create service to dojos table
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid
			@ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas";
		}
	}
}
