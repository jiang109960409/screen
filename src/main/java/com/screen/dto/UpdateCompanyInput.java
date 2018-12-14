package com.screen.dto;

import org.springframework.web.multipart.MultipartFile;

public class UpdateCompanyInput {

	private int id;
	private String name;
	private MultipartFile logoSrc;
	private String description;
	private String detail;
	private int buildingId;
	private int floorId;
	private int showLevel;

	public int getShowLevel() {
		return showLevel;
	}

	public void setShowLevel(int showLevel) {
		this.showLevel = showLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getLogoSrc() {
		return logoSrc;
	}

	public void setLogoSrc(MultipartFile logoSrc) {
		this.logoSrc = logoSrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

}
