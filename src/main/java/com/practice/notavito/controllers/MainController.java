package com.practice.notavito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Главная страница");
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
}