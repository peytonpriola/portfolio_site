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
	
	@GetMapping(value="/new")
	public String newRecommendation(Model model) {
		model.addAttribute("givenAction", "/new");
		model.addAttribute("givenAuthor", "");
		model.addAttribute("givenRelation", "");
		model.addAttribute("givenContent","");
		return "new";
	}

	@GetMapping(value="/recommendations/edit/{id}")
	public String editRecForm(Model model, @PathVariable Long id) {
		recommendationRepository.findById(id);
		model.addAttribute("recommendation", recommendationRepository.findById(id));
		return "edit";
	}
	
	@PostMapping(value="/recommendations/edit")
	public String updateRec(Model model, Recommendation recommendation) {
		recommendationRepository.save(recommendation);
		return "redirect:/";
	}
	
	
	@PostMapping(value="/new")
	 public String addNewRec(@RequestParam String author, @RequestParam String relation, @RequestParam String recEntry) {
		Recommendation newRecommendation = new Recommendation(author, relation, recEntry);
		recommendationRepository.save(newRecommendation);
		return "redirect:/recommendations";
	    }
	
	@RequestMapping(value="/recommendations/delete/{id}", method = RequestMethod.DELETE)
	public String deleteRecWithId(@PathVariable Long id, Recommendation recommendation) {
		recommendationRepository.deleteById(id);
		return "redirect:/";
	}
	
}
