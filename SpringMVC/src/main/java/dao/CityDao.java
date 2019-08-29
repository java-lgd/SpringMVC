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
public interface CityDao {
	
	@Select("select city.*,province from city inner join province on father=provinceID ${where}")
	public List<City> select(@Param("where") String txt);
	
	@Insert("insert into city(cityID,city,father) value(#{cityID},#{city},#{father})")
	public void insert(City c );
	
	@Delete("delete from city where id=#{id}")
	public void delete(int id);
	
	@Update("update city set cityID=#{cityID},city=#{city},father=#{father} where id=#{id}")
	public void update(City c);

}
