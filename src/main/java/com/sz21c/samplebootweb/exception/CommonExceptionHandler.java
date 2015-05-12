package com.sz21c.samplebootweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception e) {
		e.printStackTrace();
		
		System.out.println("file not found");
		
		ModelAndView mav = new ModelAndView("notFound");
		
		return mav;
	}
}
