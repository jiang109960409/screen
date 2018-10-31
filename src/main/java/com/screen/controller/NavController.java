package com.screen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.screen.dto.NavDTO;
import com.screen.mapper.CompanyMapper;
import com.screen.mapper.TextMapper;

/**
 * 导航栏控制器
 * 
 * @author outsider
 *
 */
@RestController
public class NavController {

	@Autowired
	private TextMapper textMapper;
	@Autowired
	private CompanyMapper companyMapper;
	
	@GetMapping("/aboutus/{name}")
	public ModelAndView getAboutUs(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "aboutus", name, textMapper.getText(1), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/companyshow/{name}")
	public ModelAndView listCompany(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "companyshow", name, companyMapper.listCompanyByBuilding(name.equals("az") ? 1 :(name.equals("bz") ? 2 : 3)), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/comein/{name}")
	public ModelAndView getComeIn(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "comein", name, textMapper.getText(2), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/service/{name}")
	public ModelAndView listService(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "service", name, textMapper.getText(3), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/job/{name}")
	public ModelAndView listJob(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "job", name, textMapper.getText(4), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/strength/{name}")
	public ModelAndView listStrength(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "strength", name, textMapper.getText(5), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/contactus/{name}")
	public ModelAndView listContactUs(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "contactus", name, textMapper.getText(6), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}
}
