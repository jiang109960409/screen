package com.screen.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.screen.domain.SlideDO;
import com.screen.dto.RestRespBody;
import com.screen.dto.UploadSlideInput;
import com.screen.mapper.SlideMapper;

/**
 * 首页幻灯片管理
 * 
 * @author outsider
 *
 */
@RestController
@RequestMapping("/slide")
public class SlideController {

	@Autowired
	private SlideMapper slideMapper;

	@GetMapping("/list")
	public ModelAndView listSlide() {
		ModelAndView mav = new ModelAndView("admin/index");
		RestRespBody rrb = new RestRespBody(slideMapper.listSlide(), false, "slide");
		mav.addObject("data", rrb);
		return mav;
	}

	@PostMapping("/add")
	public ModelAndView uploadSlide(@ModelAttribute("uploadSlideInput") UploadSlideInput input, BindingResult result)
			throws IOException {
		String relativePath = "static\\image\\slide\\";
		String imagePath = new File("").getAbsolutePath() + "\\" + relativePath;
		File fileNew = new File(imagePath);
		if (!fileNew.exists())
			fileNew.mkdirs();

		MultipartFile file = input.getImgs();
		long size = file.getSize();
		InputStream is = file.getInputStream();
		BufferedImage bufferedImage = ImageIO.read(is);
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		long id = System.currentTimeMillis();
		ImageIO.write(bufferedImage, "png", new File(imagePath + id + "." + "png"));
		SlideDO slide = new SlideDO(id, input.getName(), "image\\slide\\" + id + "." + "png", input.getAlt(), width,
				height, size, new Date(), input.getBuildingId());
		slideMapper.addSlide(slide);
		return new ModelAndView("redirect:/slide/list");
	}

	@PostMapping("/delete")
	public void listSlide(@RequestParam() Map<String, String> params, HttpServletResponse response) throws IOException {
		String idsStr = params.get("ids").substring(1);
		if (StringUtils.isNullOrEmpty(idsStr)) {
			PrintWriter out = response.getWriter();
			out.print("{\"message\":\"请选择要删除的图片\"}");
			out.flush();
			out.close();
		}
		List<Long> ids = Arrays.asList(idsStr.split(",")).parallelStream().map(l -> Long.parseLong(l)).collect(Collectors.toList());
		slideMapper.deleteSlide(ids);
		PrintWriter out = response.getWriter();
		out.print("{\"message\":\"删除成功\"}");
		out.flush();
		out.close();
	}

	@ModelAttribute("uploadSlideInput")
	public UploadSlideInput uploadSlideInput() {
		return new UploadSlideInput();
	}
}
