package com.recommendations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RecommendationController {

	@Autowired
	private RecommendationRepository recommendationRepository;
	
	@GetMapping(value="/")	
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping(value="/recommendations")
	public String recommendations(Model model) {
		List<Recommendation> allRecommendations = recommendationRepository.findAll();
		model.addAttribute("recommendations", allRecommendations);
		return "recommendations";
	}
	
	@GetMapping(value="/recommendations/new")
	public String newRecommendation(Recommendation recommendation) {
		return "new";
	}
	
	@PostMapping(value="/recommendations/new")
	 public String addNewRec(Model model, Recommendation recommendation) {
		recommendationRepository.save(recommendation);
		model.addAttribute("recommendation", recommendation);
		return "redirect:/recommendations";
	    }

	@GetMapping(value="/recommendations/edit/{id}")
	public String postRecForm(Model model, @PathVariable Long id) {
		recommendationRepository.findById(id);
		model.addAttribute("recommendation", recommendationRepository.findById(id));
		return "edit";
	}
	
	@PostMapping(value="recommendations/edit")
	public String postEdit(Model model, Recommendation recommendation) {
		recommendationRepository.save(recommendation);
		return "redirect:/recommendations";
	}
	
	@GetMapping(value="/recommendations/{id}")
	public String deleteById(@PathVariable Long id) {
		recommendationRepository.deleteById(id);
		return "redirect:/recommendations";
	}
	
}
