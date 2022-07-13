package com.practice.notavito.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.notavito.models.Ad;
import com.practice.notavito.repo.AdRepository;

@Controller
public class AdController {

	@Autowired
	private AdRepository adRepository;

	@GetMapping("/addAd")
	public String addAd(Model model) {
		return "addAd";
	}

	@PostMapping("/addAd")
	public String postAd(@RequestParam String title, @RequestParam String short_text, @RequestParam String full_text, @RequestParam int cost, Model model) {
		Ad ad = new Ad(title, short_text, full_text, cost);
		adRepository.save(ad);
        
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String adFullText(@PathVariable(value = "id") Long id, Model model) {
		if(!adRepository.existsById(id)) {
			return "redirect:/";
		}

		Optional<Ad> ad = adRepository.findById(id);
		ArrayList<Ad> res = new ArrayList<>();
		ad.ifPresent(res::add);
		model.addAttribute("ad", res);

		return "adFullText";
	}

	@GetMapping("/{id}/edit")
	public String adEdit(@PathVariable(value = "id") Long id, Model model) {
		if(!adRepository.existsById(id)) {
			return "redirect:/";
		}

		Optional<Ad> ad = adRepository.findById(id);
		ArrayList<Ad> res = new ArrayList<>();
		ad.ifPresent(res::add);
		model.addAttribute("ad", res);

		return "adEdit";
	}

	@PostMapping("/{id}/edit")
	public String adEdit(@PathVariable(value = "id") Long id, @RequestParam String title, @RequestParam String short_text, @RequestParam String full_text, @RequestParam int cost, Model model) {
		Ad ad = adRepository.findById(id).orElseThrow();
		ad.setTitle(title);
		ad.setFull_text(full_text);
		ad.setShort_text(short_text);
		ad.setCost(cost);
		adRepository.save(ad);

		return "redirect:/";
	}

	@PostMapping("/{id}/remove")
	public String adRemove(@PathVariable(value = "id") Long id, Model model) {
		Ad ad = adRepository.findById(id).orElseThrow();
		adRepository.delete(ad);

		return "redirect:/";
	}
}
