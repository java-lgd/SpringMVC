package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import model.City;

@Repository
public interface CityDao {
	
	public List<City> select(String txt);
	
	public void insert(City c );
	
	public void delete(int id);

	public void update(City c);

}
