package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import serice.CityService;

@Controller
@RequestMapping("Address")
public class CityController {
	@Autowired
	CityService service;
	
	@RequestMapping("index")
	public String index(ModelMap m,String txt) {
		String where="";
		if(txt!=null)
				where="where city like '%"+txt+"%'";
		m.put("citylist", service.select(where));
		m.put("cur", txt);
		return "Address/index";
	}
	
	@RequestMapping("delete")
	public void delete() {
		
	}
	
	@RequestMapping("add")
	public void add() {
		
	}
	
	@RequestMapping("edit")
	public void edit() {
		
	}
	
}
