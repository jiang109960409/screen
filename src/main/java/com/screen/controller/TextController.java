package com.screen.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.screen.domain.InfoDO;
import com.screen.domain.SlideDO;
import com.screen.domain.TextDO;
import com.screen.dto.RestRespBody;
import com.screen.dto.UploadSlideInput;
import com.screen.mapper.TextMapper;

/**
 * 创业园信息、关于我们等模块管理
 * 
 * @author outsider
 *
 */
@RestController
@RequestMapping("")
public class TextController {

	@Autowired
	private TextMapper textMapper;

	@GetMapping("/info/get")
	public ModelAndView getInfo() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getInfo(), false, "info");
		mav.addObject("data", rrb);
		return mav;
	}

	@PostMapping("/info/update")
	public ModelAndView updateInfo(@RequestBody String info) {
		String s2 = info.replace("data.", "").replace("\r\n", ",");
		List<String> fileds = Arrays.asList(s2.split(","));
		Map<String, String> params = new TreeMap<>();
		fileds.parallelStream().forEach(l -> params.put(l.split("=")[0], l.split("=")[1]));
		textMapper.updateInfo(new InfoDO(Integer.parseInt(params.get("id")), params.get("name"), params.get("address"),
				params.get("fax"), params.get("telephoneNumber"), Long.parseLong(params.get("phoneNumber")),
				Long.parseLong(params.get("qq")), params.get("email")));
		return new ModelAndView("redirect:/info/get");
	}

	@GetMapping("/aboutus/get")
	public ModelAndView getAboutUs() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(1), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@GetMapping("/comein/get")
	public ModelAndView getComeIn() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(2), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@GetMapping("/service/get")
	public ModelAndView getService() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(3), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@GetMapping("/job/get")
	public ModelAndView getJob() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(4), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@GetMapping("/strength/get")
	public ModelAndView getStrength() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(5), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@GetMapping("/contact/get")
	public ModelAndView getContact() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(textMapper.getText(6), false, "text");
		mav.addObject("data", rrb);
		return mav;
	}

	@PostMapping("/text/update")
	public ModelAndView updateText(@RequestBody String text) {
		int id = Integer.parseInt(text.substring(0, 9).split("=")[1]);
		String content = text.substring(19);
		textMapper.updateText(new TextDO(id, content));
		switch (id) {
		case 1:
			return new ModelAndView("redirect:/aboutus/get");
		case 2:
			return new ModelAndView("redirect:/comein/get");
		case 3:
			return new ModelAndView("redirect:/service/get");
		case 4:
			return new ModelAndView("redirect:/job/get");
		case 5:
			return new ModelAndView("redirect:/strength/get");
		case 6:
			return new ModelAndView("redirect:/contact/get");
		}
		return new ModelAndView("redirect:/admin/login");
	}

	@PostMapping("/img/upload")
	public Map<String, String> uploadImg(@RequestPart("upload") MultipartFile file) throws IOException {
		String relativePath = "src\\main\\resources\\static\\image\\";
		String imagePath = new File("").getAbsolutePath() + "\\" + relativePath;
		File fileNew = new File(imagePath);
		if (!fileNew.exists())
			fileNew.mkdirs();
		long id = System.currentTimeMillis();
		InputStream is = file.getInputStream();
		BufferedImage bufferedImage = ImageIO.read(is);
		ImageIO.write(bufferedImage, "png", new File(imagePath + id + "." + "png"));
		String pathOnServer = "/image/" + id + "." + "png";
		Map<String, String> result = new TreeMap<>();
		result.put("uploaded", "true");
		result.put("url", pathOnServer);
		return result;
	}

	@ModelAttribute("text")
	public TextDO text() {
		return new TextDO();
	}

	@ModelAttribute("info")
	public InfoDO info() {
		return new InfoDO();
	}
}
