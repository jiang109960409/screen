package com.screen.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.screen.domain.CompanyDO;
import com.screen.dto.NavDTO;
import com.screen.dto.RestRespBody;
import com.screen.dto.UploadCompanyInput;
import com.screen.mapper.CompanyMapper;
import com.screen.mapper.TextMapper;

/**
 * 入驻企业管理
 * 
 * @author outsider
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private TextMapper textMapper;
	
	@GetMapping("/list")
	public ModelAndView listSlide() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(companyMapper.listCompany(), false, "company");
		mav.addObject("data", rrb);
		return mav;
	}

	@PostMapping("/add")
	public ModelAndView uploadSlide(@ModelAttribute("uploadCompanyInput") UploadCompanyInput input)
			throws IOException {
		int buildingId = input.getBuildingId();
		int floorId = input.getFloorId();
		String relativePath = "src\\main\\resources\\static\\image\\companylogo\\" + buildingId + "\\" + floorId + "\\";
		String imagePath = new File("").getAbsolutePath() + "\\" + relativePath;
		File fileNew = new File(imagePath);
		if (!fileNew.exists())
			fileNew.mkdirs();

		MultipartFile file = input.getLogoSrc();
		InputStream is = file.getInputStream();
		BufferedImage bufferedImage = ImageIO.read(is);
		long id = System.currentTimeMillis();
		ImageIO.write(bufferedImage, "png", new File(imagePath + id + "." + "png"));
		companyMapper.addCompany(new CompanyDO(input.getName(), "\\image\\companylogo\\" + buildingId + "\\" + floorId + "\\"+ id + "." + "png", input.getDescription(), buildingId, floorId, input.getDetail()));
		return new ModelAndView("redirect:/company/list");
	}

	@PostMapping("/delete")
	public void listSlide(@RequestParam() Map<String, String> params, HttpServletResponse response) throws IOException {
		String idsStr = params.get("ids").substring(1);
		if (StringUtils.isNullOrEmpty(idsStr)) {
			PrintWriter out = response.getWriter();
			out.print("{\"message\":\"请选择要删除的企业\"}");
			out.flush();
			out.close();
		}
		List<Integer> ids = Arrays.asList(idsStr.split(",")).parallelStream().map(l -> Integer.parseInt(l)).collect(Collectors.toList());
		companyMapper.deleteCompany(ids);
		PrintWriter out = response.getWriter();
		out.print("{\"message\":\"删除成功\"}");
		out.flush();
		out.close();
	}
	
	@GetMapping("/{buildingName}/{id}/get")
	public ModelAndView getCompany(@PathVariable("id") Integer id, @PathVariable("buildingName") String buildingName) {
		ModelAndView mav = new ModelAndView("index");
		NavDTO nav = new NavDTO(false, "companydetail", buildingName, companyMapper.getCompanyDetail(id), textMapper.getInfo());
		mav.addObject("nav", nav);
		return mav;
	}

	@ModelAttribute("uploadCompanyInput")
	public UploadCompanyInput uploadCompanyInput() {
		return new UploadCompanyInput();
	}
}
