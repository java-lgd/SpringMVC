package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.City;
import service.CityService;
import service.ProvinceService;

@Controller
@RequestMapping("City")
public class CityController extends BasicController<City>{
	@Autowired
	CityService service;
	
	@Autowired
	ProvinceService	pservice;
	
	@Override
	public String index(ModelMap m,HttpServletRequest req) {
		String txt=req.getParameter("txt");
		String where="";
		if(txt!=null&&txt.length()>0)
				where="where city like '%"+txt+"%'";
		m.put("list", service.select(where));
		m.put("cur", txt);
		return "City/index";
	}
	
	@Override
	public String add(ModelMap m,HttpServletRequest req) {
		m.put("prolist", pservice.select(""));
		return "City/edit";
	}
	
}
