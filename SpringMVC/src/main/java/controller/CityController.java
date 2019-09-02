package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.City;
import model.Province;
import serice.CityService;
import serice.ProvinceService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Address")
public class CityController {
	@Autowired
	CityService service;
	
	@Autowired
	ProvinceService	pservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit,ModelMap m) {
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
	
	@RequestMapping("delete")
	public @ResponseBody String delete(ModelMap m,int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(ModelMap m,City c) {
		service.insert(c);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody City edit(ModelMap m,int id) {
		return service.selectById(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(ModelMap m,City c) {
		service.update(c);
		return "{\"status\":1}";
	}
	
	@RequestMapping("add")
	public @ResponseBody String add(ModelMap m) {
		return "Address/edit";
	}
	
	@RequestMapping("getPros")
	public @ResponseBody  List<Province> getPros(){
		return pservice.select("");
	}
	
}
