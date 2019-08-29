package serice;

import java.util.List;

import model.City;

public interface CityService {

	public List<City> select(String txt);
	
	public void insert(City c );
	
	public void delete(int id);
	
	public void update(City c);
}
