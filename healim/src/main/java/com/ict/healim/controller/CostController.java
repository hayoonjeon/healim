package com.ict.healim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class CostController {

	@RequestMapping("/cost")
	public ModelAndView cost() {
		ModelAndView mv = new ModelAndView("/cost/cost");

		return mv;
	}
	
	
    @RequestMapping("/calculate")
    public String calculate(@RequestParam("grade") int grade,
                            @RequestParam("careTime") int careTime,
                            @RequestParam("days") int days,
                            @RequestParam("extraRate") int extraRate,
                            Model model) {

        // ?±κΈλ³ ???‘ ?€?  (κΈ°λ³Έκ°?: 0)
        int monthlyLimit = 0;
        switch (grade) {
            case 1: monthlyLimit = 2069900; break;
            case 2: monthlyLimit = 1869600; break;
            case 3: monthlyLimit = 1455800; break;
            case 4: monthlyLimit = 1341800; break;
            case 5: monthlyLimit = 1151600; break;
        }

        // ?λ΄μκ°?, ?΄?©?Ό?, κ°??°?¨ ?€? 
        int totalCost = careTime * days;
        int adjustedCost = totalCost + (totalCost * extraRate / 100);

        // κ³΅λ¨ μ§??κΈ? κ³μ°
        int supportAmount = Math.min(monthlyLimit, adjustedCost);

        // λ³ΈμΈ λΆ??΄κΈ? κ³μ°
        int userPay = adjustedCost - supportAmount;

        // ?¨?? ???‘κ³? μ΄κ³Ό ?¬λΆ? κ³μ°
        int remainingLimit = monthlyLimit - supportAmount;
        boolean isExceeded = adjustedCost > monthlyLimit;
        int excessAmount = adjustedCost - monthlyLimit;

        // NumberFormat? ?¬?©?΄ 3?λ¦¬λ§?€ ?Ό? μΆκ?
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        // λͺ¨λΈ? κ³μ° κ²°κ³Ό μΆκ? (?Ό? ?? ? ?©)
        model.addAttribute("monthlyLimit", numberFormat.format(monthlyLimit));
        model.addAttribute("totalCost", numberFormat.format(totalCost));
        model.addAttribute("adjustedCost", numberFormat.format(adjustedCost));
        model.addAttribute("supportAmount", numberFormat.format(supportAmount));
        model.addAttribute("userPay", numberFormat.format(userPay));
        model.addAttribute("remainingLimit", numberFormat.format(remainingLimit));
        model.addAttribute("excessAmount", excessAmount); // μ΄κ³Ό κΈμ‘ μΆκ?
        model.addAttribute("isExceeded", isExceeded);

        return "/cost/calculate"; // "cost.jsp" λ·°λ‘ ?΄?
    }
}
