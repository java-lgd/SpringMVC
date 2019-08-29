package serice;

import java.util.List;

import model.Province;

public interface ProvinceService {

	public List<Province> select(String txt);
	
	public void insert(Province c );
	
	public void delete(int id);
	
	public void update(Province c);
}
