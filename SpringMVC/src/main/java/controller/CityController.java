package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.City;
import serice.CityService;
import serice.ProvinceService;

@Controller
@RequestMapping("Address")
public class CityController {
	@Autowired
	CityService service;
	
	@Autowired
	ProvinceService	pservice;
	
	@RequestMapping("index")
	public String index(ModelMap m,String txt) {
		String where="";
		if(txt!=null&&txt.length()>0)
				where="where city like '%"+txt.trim()+"%'";
		m.put("citylist", service.select(where));
		m.put("cur", txt);
		return "Address/index";
	}
	
	@RequestMapping("delete")
	public String delete(ModelMap m,int id) {
		service.delete(id);
		return index(m,null);
	}
	
	@RequestMapping("insert")
	public String insert(ModelMap m,City c) {
		service.insert(c);
		return index(m,null);
	}
	
	@RequestMapping("edit")
	public String edit(ModelMap m,int id) {
		m.put("prolist", pservice.select(null));
		m.put("city",service.selectById(id));
		return "Address/edit";
	}
	
	@RequestMapping("update")
	public String update(ModelMap m,City c) {
		service.update(c);
		return index(m,null);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		m.put("prolist", pservice.select(null));
		return "Address/edit";
	}
	
}
