package controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceImpl.BasicServiceImpl;
import utils.ReturnInfo;


@Controller
public class BasicController<T>  {
	
	serviceImpl.BasicServiceImpl<T> basicservice;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f=this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object service=f.get(this);
		basicservice= (BasicServiceImpl<T>) service;
	}
	
	private String getTname() {
		return getRealType().getSimpleName();
	}
	
	public Class getRealType(){
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
		
	
	@RequestMapping("delete")
	public @ResponseBody String delete(Integer id,HttpServletRequest req) {
		basicservice.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody T edit(Integer id,HttpServletRequest req) {
		return basicservice.selectById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(T t,HttpServletRequest req) {
		basicservice.insert(t);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(T t,HttpServletRequest req) {
		basicservice.update(t);
		return "{\"status\":1}";
	}
}
