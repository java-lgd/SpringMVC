package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProvinceDao;
import model.Province;
import service.ProvinceService;

@Service
public class ProvinceServiceImpl extends BasicServiceImpl<Province> implements ProvinceService{
	
	@Autowired
	ProvinceDao dao;

	

}
