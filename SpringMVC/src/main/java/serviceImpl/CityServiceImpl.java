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

	public int selectCount(String txt) {
		return dao.selectCount(txt);
	}

	public List<City> select(String txt,String limit) {
		return dao.select(txt,limit);
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
	
	public City selectById(int id){
		return  dao.selectById(id);
	}
	
}
