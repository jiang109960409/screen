package com.screen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.screen.domain.SlideDO;

@Mapper
public interface SlideMapper {

	@Results(id="slide", value= {
			@Result(column="file_size", property="fileSize"),
			@Result(column="upload_date", property="uploadDate"),
			@Result(column="building_id", property="buildingId"),
	})
	@Select("select * from admin_slide order by upload_date desc;")
	List<SlideDO> listSlide();

	@Insert("insert into admin_slide(id, name, src, alt, width, height, file_size, upload_date, building_id) values(#{id}, #{name}, #{src}, #{alt}, #{width}, #{height}, #{fileSize}, #{uploadDate}, #{buildingId})")
	Integer addSlide(SlideDO slide);

	@Delete("<script>"
			+ "delete from admin_slide where id in"
			+ "<foreach collection='ids' item='id' open='(' close=')' separator=','>"
			+ "#{id}"
			+ "</foreach>"
			+ "</script>")
	Integer deleteSlide(@Param("ids") List<Long> ids);
}
