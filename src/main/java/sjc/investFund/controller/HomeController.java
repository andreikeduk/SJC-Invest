package sjc.investFund.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Area;
import sjc.investFund.model.User;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "")
public class HomeController {
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session){
		
		Map<Integer, String> areaList = new LinkedHashMap<Integer, String>();

		List<Area> areas = areaService.findAllAreas();
		for (Area a : areas) {
			areaList.put(a.getId(), a.getName());
		}
		session.setAttribute("arealist", areaList);
		
		
		return "home";
	}
	@RequestMapping(value = "/access-denied", method = { RequestMethod.GET })
	public String denied() {
		return "denied";
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		//session.invalidate();
		return model;
	}
	@RequestMapping(value = "/redirector")
	public String redirect(Authentication auth){
		
		User user = userService.findByLogin(auth.getName());
		return "redirect:/" + user.getRole().toString().toLowerCase();
	}
	
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs() {
		return "aboutUs";
	}
}
