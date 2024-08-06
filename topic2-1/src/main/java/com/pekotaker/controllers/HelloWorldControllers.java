package com.pekotaker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pekotaker.models.Person;

@Controller
public class HelloWorldControllers {
	
	@GetMapping("/test")
	@ResponseBody
	public String printHello() {
		return "Hello World";
	}
	
	@GetMapping("/hello")
	public String showHello(Model model) {
		model.addAttribute("message", "Have a great day!");
		model.addAttribute("rating", 10);
		model.addAttribute("report", "Nothing to report yet.");
		return "helloPage.html";
	}
	
	@GetMapping("/modelHello")
	public ModelAndView modelHello() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", "Have a nice day!");
		mv.addObject("rating", 9);
		mv.addObject("report", "Nothing to report yet, still.");
		mv.setViewName("helloPage");
		return mv;
	}
	
	@GetMapping("/hello4")
	public String showHelloPage4(@RequestParam String msg, Model model) {
		model.addAttribute("message", msg);
		model.addAttribute("rating", 10);
		model.addAttribute("report", "Nothing to report yet.");
		return "helloPage.html";
	}
	
	@GetMapping("/people")
	public String showPeople(Model model) {
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person(0, "Alan Walker", 23, 9));
		people.add(new Person(1, "Jane Doe", 28, 7));
		people.add(new Person(2, "John Smith", 35, 5));
		people.add(new Person(3, "Emily Davis", 22, 8));
		people.add(new Person(4, "Michael Brown", 30, 6));

		model.addAttribute("people", people);
		return "peoplePage.html";
	}
	
}
