package com.example.demo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class SaludoController {
 @GetMapping(value = "Saludo", produces=MediaType.TEXT_PLAIN_VALUE)
 public String saludoRest() {
	 return "Microservicio ejermplo realizado en SpringBoot";
 }
}
