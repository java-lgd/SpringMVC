package serice;

import java.util.List;

import model.City;

public interface CityService {
	
	public int selectCount(String txt);

	public List<City> select(String txt,String limit);
	
	public void insert(City c );
	
	public void delete(int id);
	
	public void update(City c);
	
	public City selectById(int id);
}
