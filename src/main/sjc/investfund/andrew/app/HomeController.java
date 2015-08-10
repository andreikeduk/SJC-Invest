package sjc.investfund.andrew.app;

import java.util.Map;


/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sjc.investfund.andrew.domain.User;
import sjc.investfund.andrew.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
    public String home() {
        return "redirect:/index";
    }
	@RequestMapping(value = "/index")
	public String listUsers(Map<String, Object> map){
		map.put("user", new User());
		map.put("userList", userService.usersList());
		return "user";
	}
	
}
