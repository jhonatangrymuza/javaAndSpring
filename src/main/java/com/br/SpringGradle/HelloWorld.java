package com.br.SpringGradle;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/")
public class HelloWorld {

	
	@GetMapping
	public String sayHello() {
		return "Hello from SpringBoot by Jhonatan";
	}

	//exemplo de post
	@PostMapping("/post")
	public String sayHelloPost(@RequestBody Map<String, Object> payload) {
		
		return payload.get("name").toString();
		
	}
	// sub path para o mesmo end - point com request paramento ?nome=jhonatan
	@GetMapping("/subpath")
	public String subPath(@RequestParam("name") String name) {
		return "This is one subPath of Endpoint/ " + name;
	}
	
	// sub path para o mesmo end - point com WebRequest paramento ?nome=jhonatan
	@GetMapping("/param")
	public String param(final WebRequest webRequest) {
		String name = webRequest.getParameter("name");
		return "This is one param of Endpoint/ " + name;
	}
	
	// sub path para o mesmo end - point com request param paramento ?nome=jhonatan
	@GetMapping("/requestParam")
	@ResponseBody 
	@ResponseStatus(code = HttpStatus.NO_CONTENT) // permite que eu consiga colocar um codigo customisado do meu resultado da requisição 
	public String requestParam(@RequestParam(value="name",required = false) String name) {
		return "This is one param of Endpoint/ " + name;
	}
	
	// rota dinamica 
	@GetMapping("/{dynamic}")
	public String dynamicSubPath(@PathVariable("dynamic") String name) {
		return "Hello " + name + " this is my route dynamic...";
	}
}
