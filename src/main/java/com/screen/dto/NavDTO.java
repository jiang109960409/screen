package com.screen.dto;

import java.util.List;
import java.util.Map;

import com.screen.domain.CompanyDO;
import com.screen.domain.InfoDO;

/**
 * 页面传递
 * 
 * @author outsider
 *
 */
public class NavDTO {
	public boolean isHome;
	public String fragmentName;
	public String buildingName; // 三种值：az bz cz
	public Object data;
	public InfoDO info;
	public Map<Integer, List<CompanyDO>> company; // key:floorId value:companies
	public List<CompanyLogoDTO> logos;
	
	public NavDTO() {
	}

	public NavDTO(boolean isHome, String fragmentName) {
		this.isHome = isHome;
		this.fragmentName = fragmentName;
	}

	public NavDTO(boolean isHome, String fragmentName, String buildingName) {
		this.isHome = isHome;
		this.fragmentName = fragmentName;
		this.buildingName = buildingName;
	}

	public NavDTO(boolean isHome, String fragmentName, String buildingName, Object data) {
		this.isHome = isHome;
		this.fragmentName = fragmentName;
		this.buildingName = buildingName;
		this.data = data;
	}

	public NavDTO(boolean isHome, String fragmentName, String buildingName, Object data, InfoDO info) {
		super();
		this.isHome = isHome;
		this.fragmentName = fragmentName;
		this.buildingName = buildingName;
		this.data = data;
		this.info = info;
	}

	public NavDTO(boolean isHome, String fragmentName, String buildingName, Object data, InfoDO info,
			Map<Integer, List<CompanyDO>> company) {
		super();
		this.isHome = isHome;
		this.fragmentName = fragmentName;
		this.buildingName = buildingName;
		this.data = data;
		this.info = info;
		this.company = company;
	}

	public NavDTO(boolean isHome, String fragmentName, String buildingName, Object data, InfoDO info,
			Map<Integer, List<CompanyDO>> company, List<CompanyLogoDTO> logos) {
		super();
		this.isHome = isHome;
		this.fragmentName = fragmentName;
		this.buildingName = buildingName;
		this.data = data;
		this.info = info;
		this.company = company;
		this.logos = logos;
	}

	@Override
	public String toString() {
		return "NavDTO [isHome=" + isHome + ", fragmentName=" + fragmentName + ", buildingName=" + buildingName
				+ ", data=" + data + ", info=" + info + ", company=" + company + "]";
	}

}
