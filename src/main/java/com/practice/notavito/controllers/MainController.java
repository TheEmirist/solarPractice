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
public class MainController {

	@Autowired
	private AdRepository adRepository;

	@GetMapping("/")
	public String home(@RequestParam(required = false) String filter, Model model) {
		Iterable<Ad> ads = adRepository.findAll();

		if (filter != null && !filter.isEmpty()) {
			ads = adRepository.findByTag(filter);
		} else {
			ads = adRepository.findAll();
		}

		model.addAttribute("ads", ads);
		model.addAttribute("filter", filter);

		return "home";
	}

	@GetMapping("/transport")
	public String transport(Model model) {
		model.addAttribute("title", "Транспорт");
		return "transport";
	}

	@GetMapping("/re")
	public String re(Model model) {
		model.addAttribute("title", "Недвижимость");
		return "re";
	}

	@GetMapping("/job")
	public String job(Model model) {
		model.addAttribute("title", "Работат");
		return "job";
	}

	@GetMapping("/service")
	public String service(Model model) {
		model.addAttribute("title", "Услуги");
		return "service";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Вход");
		return "login";
	}
}