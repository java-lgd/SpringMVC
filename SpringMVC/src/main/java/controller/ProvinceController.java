package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Province;
import service.ProvinceService;

@Controller
@RequestMapping("Province")
public class ProvinceController extends BasicController<Province>{
	@Autowired
	ProvinceService	service;
}
