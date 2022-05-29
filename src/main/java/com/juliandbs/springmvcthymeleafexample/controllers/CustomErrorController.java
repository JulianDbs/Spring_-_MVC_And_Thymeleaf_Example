package com.juliandbs.springmvcthymeleafexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;

/**
*	@author JulianDbs
*/
@Controller
public class CustomErrorController implements ErrorController {

	@GetMapping("/errors")
	public String handleError(HttpServletRequest request) {
		String error = "errors/error";
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			switch (statusCode) {
				case 404 :
					error = "errors/error-404";
					break;
				case 500 :
					error = "errors/error-500";
					break;
				default :
					error = "errors/error";
					break;
			}
		}
		return error;
	}
}
