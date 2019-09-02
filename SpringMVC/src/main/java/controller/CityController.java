package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.City;
import model.Province;
import serice.CityService;
import serice.ProvinceService;
import utils.ReturnInfo;

@Controller
public class CityController {
	@Autowired
	CityService service;
	
	@Autowired
	ProvinceService	pservice;
	
	@RequestMapping(value="Address", method = RequestMethod.GET)
	public @ResponseBody ReturnInfo index(String txt, Integer page,Integer limit,ModelMap m) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null&&txt.length()>0)
				where="where city like '%"+txt.trim()+"%'";
		String lim = info.getLimit(page, limit);
		info.setList(service.select(where,lim));
		info.setCount(service.selectCount(where));
		m.put("cur", txt);
		return info;
	}
	
	@RequestMapping(value="Address/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value="Address", method = RequestMethod.POST)
	public @ResponseBody String insert(City c) {
		service.insert(c);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value="Address/{id}",method=RequestMethod.GET)
	public @ResponseBody City edit(@PathVariable("id") Integer id) {
		return service.selectById(id);
	}
	
	@RequestMapping(value="Address",method=RequestMethod.PUT)
	public @ResponseBody String update(City c) {
		service.update(c);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value="Address/getPros",method=RequestMethod.GET)
	public @ResponseBody  List<Province> getPros(){
		return pservice.select("");
	}
	
}
