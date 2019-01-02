package com.screen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.screen.domain.SlideDO;
import com.screen.domain.UserDO;

@Mapper
public interface AppMapper {

	@Select("select * from admin_user where username = #{username} and password = #{password} limit 1")
	UserDO getUser(@Param("username") String username, @Param("password") String password);

	@Select("select * from admin_slide where building_id = #{arg1} or building_id = 4 order by upload_date desc")
	List<SlideDO> listSlide(int buildingId);

}
