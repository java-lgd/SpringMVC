package controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import serviceImpl.BasicServiceImpl;


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
		
	@RequestMapping("index")
	public String index(ModelMap m,HttpServletRequest req) {
		m.put("list", basicservice.select(""));
		return getTname()+"/index";
	}
	
	@RequestMapping("delete")
	public String delete(Integer id,ModelMap m,HttpServletRequest req) {
		basicservice.delete(id);
		 return index( m,req);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m,HttpServletRequest req) {
		return getTname()+"/edit";
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,ModelMap m,HttpServletRequest req) {
		m.put("info", basicservice.selectById(id));
		return add( m,req);
	}
	
	@RequestMapping("insert")
	public String insert(T t,ModelMap m,HttpServletRequest req) {
		basicservice.insert(t);
		return index( m,req);
	}
	
	@RequestMapping("update")
	public String update(T t,ModelMap m,HttpServletRequest req) {
		basicservice.update(t);
		return index( m,req);
	}
}
