package br.edu.utfpr.pb.aula1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@GetMapping("")
	@ResponseBody
	public String index() {
		return "Hi mundo!";
	}
	
	@GetMapping({"teste", "outroteste"})
	@ResponseBody
	public String teste() {
		return "teste!";
	}
}
