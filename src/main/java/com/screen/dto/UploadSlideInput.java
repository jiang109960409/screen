package com.screen.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadSlideInput {

	private MultipartFile imgs;
	private String name;
	private String alt;
	private int buildingId;

	public MultipartFile getImgs() {
		return imgs;
	}

	public void setImgs(MultipartFile imgs) {
		this.imgs = imgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "UploadSlideInput [imgs=" + imgs + ", name=" + name + ", alt=" + alt + ", buildingId=" + buildingId
				+ "]";
	}

}
