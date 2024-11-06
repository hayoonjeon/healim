package com.ict.healim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.healim.service.AdminService;
import com.ict.healim.vo.AdminVO;

@Controller
public class AdminController {

	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public ModelAndView getAdminList() {
	ModelAndView mv = new ModelAndView("admin_pages/admin"); 
		List<AdminVO> list = adminService.getAdminList();
		System.out.println("-------------");
		mv.addObject("list", list);
		
		
		return mv;
	}
	
	
	 @GetMapping("/admin_create")
	    public ModelAndView goToAdmin() {
	        // `/admin` ��û �� `admin_create` �������� �̵�
	        return new ModelAndView("admin_pages/admin_create");
	    }
	
	
	
	@PostMapping("/admin_add")
	public ModelAndView insertAdmin(AdminVO avo) {
		ModelAndView mv= new ModelAndView();
		int result = adminService.getAdminInsert(avo);
		System.out.println("result: " + result);
		mv.setViewName("redirect:/index");
		return mv;
	}
	
	@GetMapping("/admin_delete")
	public ModelAndView deleteAdmin(@ModelAttribute("admin_id")String admin_id) {
		int result = adminService.getAdminDelete(admin_id);
		return new ModelAndView("redirect:/admin");
		
	}
	
	@PostMapping("/admin_detail_ok")
	public ModelAndView editAdmin(AdminVO avo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		
		System.out.println("avo.getChat_auth()" + avo.getChat_auth());
		int result = adminService.getAdminUpdate(avo);

		System.out.println("result:"+result);
		mv.setViewName("redirect:/index");
		return mv;
		
	}
	
	
	
	
}
