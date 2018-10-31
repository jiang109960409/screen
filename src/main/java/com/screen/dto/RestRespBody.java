package com.screen.dto;

public class RestRespBody {

	public Object data;
	public boolean isHome;
	public String moduleName;

	public RestRespBody() {
	}

	public RestRespBody(Object data, boolean isHome) {
		this.data = data;
		this.isHome = isHome;
	}

	public RestRespBody(Object data, boolean isHome, String moduleName) {
		this.data = data;
		this.isHome = isHome;
		this.moduleName = moduleName;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isHome() {
		return isHome;
	}

	public void setHome(boolean isHome) {
		this.isHome = isHome;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
