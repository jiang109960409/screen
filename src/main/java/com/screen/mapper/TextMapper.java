package com.screen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.screen.domain.InfoDO;
import com.screen.domain.TextDO;

@Mapper
public interface TextMapper {

	@Results(id="info", value= {
			@Result(column="telephone_number", property="telephoneNumber"),
			@Result(column="phone_number", property="phoneNumber")
	})
	@Select("select * from admin_info limit 1")
	InfoDO getInfo();

	@Update("update admin_info set name=#{name}, address=#{address}, fax=#{fax}, telephone_number=#{telephoneNumber}, phone_number=#{phoneNumber}, qq=#{qq}, email=#{email} where id=#{id}")
	Integer updateInfo(InfoDO info);
	
	@Select("select * from admin_text where id = #{arg1}")
	TextDO getText(int moduleId);
	
	@Update("update admin_text set text=#{text} where id=#{id}")
	Integer updateText(TextDO textDO);
}
