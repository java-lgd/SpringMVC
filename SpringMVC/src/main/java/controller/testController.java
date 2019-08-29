package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	
	@RequestMapping("index")
	public void index(String txt,ModelMap m) {
		System.out.println(123);
		m.put("my", txt);
	}

}
