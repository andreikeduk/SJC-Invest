package sjc.investFund.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Area;
import sjc.investFund.model.Role;
import sjc.investFund.model.User;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private AreaService areaService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = { "", "/"}, method = RequestMethod.GET)
	public String login(HttpSession session) {
		Map<Integer, String> areaList = new LinkedHashMap<Integer, String>();

		List<Area> areas = areaService.findAllAreas();
		for (Area a : areas) {
			areaList.put(a.getId(), a.getName());
		}
		session.setAttribute("arealist", areaList);
		return "login";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password,
			HttpRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		User user = userService.findByLoginAndPassword(login, password);
		//session.setAttribute("user", user.getLogin());
		//mav.addObject("user", user);
		// mav.addObject("projectlist",
		// projectService.findProjectsByUser(user));
		mav.setViewName("redirect:/redirector");
		return mav;
	}

	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		logger.debug("Failed login");
		return "login";
	}
	
	
}
