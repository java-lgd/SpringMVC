package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.City;

@Repository
public interface CityDao{
	
	@Select("select count(1) from city  ${txt}")
	public int selectCount(@Param("txt") String txt);
	
	@Select("select city.*,province from city inner join province on father=provinceID ${where} ${limit} ")
	public List<City> select(@Param("where") String txt,@Param("limit") String limit);
	
	@Insert("insert into city(cityID,city,father) value(#{cityID},#{city},#{father})")
	public Integer insert(City c );
	
	@Delete("delete from city where id=#{id}")
	public Integer delete(@Param("id") Integer id);
	
	@Update("update city set cityID=#{cityID},city=#{city},father=#{father} where id=#{id}")
	public Integer update(City c);

	@Select("select *  from city where id=#{id}")
	public City selectById(@Param("id") Integer id);
}
