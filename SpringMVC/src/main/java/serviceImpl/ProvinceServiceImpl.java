package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProvinceDao;
import model.Province;
import serice.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{
	
	@Autowired
	ProvinceDao dao;

	public List<Province> select(String txt) {
		return dao.select(txt);
	}

	public void insert(Province c) {
		dao.insert(c);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(Province c) {
		dao.update(c);
	}

}
