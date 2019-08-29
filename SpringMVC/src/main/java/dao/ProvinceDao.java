package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Province;

public interface ProvinceDao {
	@Select("select * from province ${where}")
	public List<Province> select(@Param("where") String txt);
	
	@Insert("insert into province(provinceID,province) value(#{provinceID},#{province})")
	public void insert(Province c );
	
	@Delete("delete from province where id=#{id}")
	public void delete(int id);
	
	@Update("update city set provinceID=#{provinceID},province=#{province} where id=#{id}")
	public void update(Province c);
}
