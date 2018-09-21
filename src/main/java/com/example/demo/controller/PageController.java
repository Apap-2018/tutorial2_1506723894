package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challenge(@PathVariable Optional<String> name , Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam String a, String b, Model model) {
		Integer intA = Integer.parseInt(a);
		Integer intB = Integer.parseInt(b);
		String charM = "";
		
		for(int i = 0; i < intA; i++) {
			charM += "m"; 
		}
		
		String printHm = "";
		if(intA > 1) {
			for(int i = 0; i < intB; i++) {
				printHm += "h" + charM + " ";
			}
		} else {
			for(int i = 0; i < intB; i++) {
				printHm += "hm ";
			}
		}
		
		model.addAttribute("a", intA);
		model.addAttribute("b", intB);
		model.addAttribute("printHm", printHm);
		
		return "generator";
	}
}
