package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@GetMapping("/welcome")
	public ModelAndView WelcomeMsg() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome Message !!!");
		mav.setViewName("welcome");
		return mav;
	}
	
	@GetMapping("/greet")
	public String greetMsg(Model model) {
		String msgText = "Good Morning";
		model.addAttribute("msg", msgText);
		return "greet";
	}
	
	@GetMapping("/wish")
	@ResponseBody
	public String wishMsg() {
		String msg = "All The Best !!";
		return "<h1>" + msg + "</h2>";
	}
}
