package com.publicationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.publicationapp.model.Publication;
import com.publicationapp.service.PublicationService;
import com.publicationapp.serviceimpl.PublicationServiceImpl;

@Controller
public class PublicationController {
	@Autowired
	private PublicationServiceImpl publicationServiceImpl;
	
	//Save or update
	@PostMapping("/save-publication")
	public String save(@ModelAttribute Publication publication) {
		int result = publicationServiceImpl.save(publication);
		System.out.println(result);
		return "redirect:/publication-list";
	}
	
	@GetMapping("/publication-list")
	public ModelAndView getAll() {
		List<Publication> publications = publicationServiceImpl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("publication-list");
		mv.addObject("list",publications);
		return mv;
	}
	
	@GetMapping(value = "remove-publication/{id}")
	public String remove(@PathVariable("id") int id) {
		publicationServiceImpl.remove(id);
		return "redirect:/publication-list";
	}
	
	@GetMapping(value = "update-publication/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		Publication publication = (id==0) ? new Publication() : publicationServiceImpl.getById(id);
		model.addAttribute("publication", publication);
		return "index";
	}

}
