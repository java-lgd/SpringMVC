package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CityDao;
import model.City;
import serice.CityService;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	CityDao dao;

	public List<City> select(String txt) {
		return dao.select(txt);
	}

	public void insert(City c) {
		dao.insert(c);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(City c) {
		dao.update(c);
	}

}
