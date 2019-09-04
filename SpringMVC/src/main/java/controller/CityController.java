package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.City;
import model.Province;
import service.CityService;
import service.ProvinceService;
import utils.ReturnInfo;

@Controller
@RequestMapping("City")
public class CityController extends BasicController<City>{
	@Autowired
	CityService service;
	
	@Autowired
	ProvinceService	pservice;
	
	
	@RequestMapping("getPros")
	public @ResponseBody  List<Province> getPros(){
		return pservice.select("","");
	}
	
}
