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
	private int showLevel;

	public CompanyDO() {
	}

	public CompanyDO(int id, String name, String logoSrc, String description, String detail, int buildingId,
			int floorId, int showLevel) {
		super();
		this.id = id;
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.detail = detail;
		this.buildingId = buildingId;
		this.floorId = floorId;
		this.showLevel = showLevel;
	}

	public CompanyDO(int id, String name, String logoSrc, String description, String detail, int buildingId,
			int floorId) {
		super();
		this.id = id;
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.detail = detail;
		this.buildingId = buildingId;
		this.floorId = floorId;

	}

	public CompanyDO(String name, String logoSrc, String description, int buildingId, int floorId, String detail,
			int showLevel) {
		this.name = name;
		this.logoSrc = logoSrc;
		this.description = description;
		this.buildingId = buildingId;
		this.floorId = floorId;
		this.detail = detail;
		this.showLevel = showLevel;
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

	public int getShowLevel() {
		return showLevel;
	}

	public void setShowLevel(int showLevel) {
		this.showLevel = showLevel;
	}

}
