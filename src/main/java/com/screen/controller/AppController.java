package com.screen.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.StringUtils;
import com.screen.domain.CompanyDO;
import com.screen.domain.UserDO;
import com.screen.dto.NavDTO;
import com.screen.dto.RestRespBody;
import com.screen.mapper.AppMapper;
import com.screen.mapper.CompanyMapper;
import com.screen.mapper.TextMapper;

/**
 * 主页控制器
 * 
 * @author outsider
 *
 */
@RestController
public class AppController {

	@Autowired
	private AppMapper appMapper;
	@Autowired
	private TextMapper textMapper;
	@Autowired
	private CompanyMapper companyMapper;

	@GetMapping("/az")
	public ModelAndView getAzIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		List<Integer> floorIds = companyMapper.listFloorId(1);
		Map<Integer, List<CompanyDO>> companies = new TreeMap<>();
		floorIds.forEach(l -> companies.put(l, companyMapper.listCompanyByFloorId(1, l)));
		NavDTO nav = new NavDTO(true, "", "az", appMapper.listSlide(1), textMapper.getInfo(), companies, companyMapper.listCompanyLogo(1));
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/bz")
	public ModelAndView getBzIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		List<Integer> floorIds = companyMapper.listFloorId(2);
		Map<Integer, List<CompanyDO>> companies = new TreeMap<>();
		floorIds.forEach(l -> companies.put(l, companyMapper.listCompanyByFloorId(2, l)));
		NavDTO nav = new NavDTO(true, "", "bz", appMapper.listSlide(2), textMapper.getInfo(), companies, companyMapper.listCompanyLogo(2));
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/cz")
	public ModelAndView getCzIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		List<Integer> floorIds = companyMapper.listFloorId(3);
		Map<Integer, List<CompanyDO>> companies = new TreeMap<>();
		floorIds.forEach(l -> companies.put(l, companyMapper.listCompanyByFloorId(3, l)));
		NavDTO nav = new NavDTO(true, "", "cz", appMapper.listSlide(3), textMapper.getInfo(), companies, companyMapper.listCompanyLogo(3));
		mav.addObject("nav", nav);
		return mav;
	}

	@GetMapping("/admin/login")
	public ModelAndView getAdminLoginPage() {
		return new ModelAndView("admin/login");
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam Map<String, String> params, RedirectAttributes attrs) {
		String username = params.get("username");
		String password = params.get("password");
		if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
			ModelAndView mav = new ModelAndView("admin/login");
			mav.addObject("message", "账号或密码不能为空");
			return mav;
		}
		UserDO user = appMapper.getUser(username, password);
		if (user == null) {
			ModelAndView mav = new ModelAndView("admin/login");
			mav.addObject("message", "账号或密码错误");
			return mav;
		}
		return new ModelAndView("redirect:admin/index");
	}

	@GetMapping("/admin/index")
	public ModelAndView redirectToAdminIndex() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody("", true);
		mav.addObject("data", rrb);
		return mav;
	}
}
