package com.screen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.screen.domain.CompanyDO;
import com.screen.dto.CompanyLogoDTO;

@Mapper
public interface CompanyMapper {

	@Results(id="company", value= {
			@Result(column="logo_src", property="logoSrc"),
			@Result(column="floor_id", property="floorId"),
			@Result(column="building_id", property="buildingId"),
	})
	@Select("select * from admin_company order by building_id asc;")
	List<CompanyDO> listCompany();
	
	@Insert("insert into admin_company(name, logo_src, description, building_id, floor_id, detail) values(#{name}, #{logoSrc}, #{description}, #{buildingId}, #{floorId}, #{detail})")
	Integer addCompany(CompanyDO company);

	@Delete("<script>"
			+ "delete from admin_company where id in"
			+ "<foreach collection='ids' item='id' open='(' close=')' separator=','>"
			+ "#{id}"
			+ "</foreach>"
			+ "</script>")
	Integer deleteCompany(@Param("ids") List<Integer> ids);

	@ResultMap("company")
	@Select("select * from admin_company where building_id = #{arg1} order by floor_id asc;")
	List<CompanyDO>  listCompanyByBuilding(int buildingId);

	@Select("select distinct floor_id from admin_company where building_id = #{arg1} order by floor_id asc")
	List<Integer> listFloorId(int buildingId);

	@ResultMap("company")
	@Select("select * from admin_company where building_id = #{buildingId} and floor_id = #{floorId} order by id desc;")
	List<CompanyDO>  listCompanyByFloorId(@Param("buildingId") int buildingId, @Param("floorId") int floorId);

	@Results(id="companyLogo", value= {
			@Result(column="logo_src", property="logoSrc")
	})
	@Select("select id, logo_src from admin_company where building_id = #{arg1} order by floor_id asc")
	List<CompanyLogoDTO> listCompanyLogo(int buildingId);
	
	@Select("select detail from admin_company where id = #{arg1}")
	String getCompanyDetail(int id);
}
