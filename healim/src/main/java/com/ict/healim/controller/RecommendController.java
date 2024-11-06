package com.ict.healim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RecommendController {
	@RequestMapping("/recommend")
	public ModelAndView recommend(@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView("recommend");
		mv.addObject("value", value);
		return mv;
	}
}
