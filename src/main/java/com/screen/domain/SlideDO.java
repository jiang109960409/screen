package com.screen.domain;

import java.util.Date;

/**
 * 幻灯片实体类
 * 
 * @author outsider
 *
 */
public class SlideDO {

	private long id;
	private String name;
	private String src;
	private String alt;
	private int width;
	private int height;
	private long fileSize;
	private Date uploadDate;
	private int buildingId;

	public SlideDO() {
	}

	public SlideDO(long id, String name, String src, String alt, int width, int height, long fileSize, Date uploadDate,
			int buildingId) {
		this.id = id;
		this.name = name;
		this.src = src;
		this.alt = alt;
		this.width = width;
		this.height = height;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.buildingId = buildingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

}
