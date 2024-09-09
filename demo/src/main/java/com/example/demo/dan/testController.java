package com.example.demo.dan;

import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class testController {
	
	private static final List<Dan> DAN_LIST = List.of(new Dan("dan","hi"),
			new Dan("dan","hee"));

	@GetMapping("/danhee")
	public List<Dan> danhee() {
		return DAN_LIST ;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken csrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
}

record Dan(String username, String description) {}