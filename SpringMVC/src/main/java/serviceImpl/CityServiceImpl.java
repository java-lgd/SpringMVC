package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CityDao;
import model.City;
import service.CityService;

@Service
public class CityServiceImpl extends BasicServiceImpl<City> implements CityService{
	
	@Autowired
	CityDao dao;

}
