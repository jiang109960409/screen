package com.screen.domain;

/**
 * 企业实体
 * 
 * @author outsider
 *
 */
public class CompanyDO {

	private int id;
	private String name;
	private String logoSrc;
	private String description;
	private String detail;
	private int buildingId;
	private int floorId;

	public CompanyDO() {
	}

	public CompanyDO(String name, String logoSrc, String description, int buildingId, int floorId) {
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.buildingId = buildingId;
		this.floorId = floorId;
	}

	public CompanyDO(int id, String name, String logoSrc, String description, int buildingId, int floorId) {
		this.id = id;
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.buildingId = buildingId;
		this.floorId = floorId;
	}
	public CompanyDO(String name, String logoSrc, String description, int buildingId, int floorId, String detail) {
		this.id = id;
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.buildingId = buildingId;
		this.floorId = floorId;
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public String getLogoSrc() {
		return logoSrc;
	}

	public void setLogoSrc(String logoSrc) {
		this.logoSrc = logoSrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
