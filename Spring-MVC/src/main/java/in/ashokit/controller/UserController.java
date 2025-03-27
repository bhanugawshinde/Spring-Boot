package in.ashokit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bean.User;
import jakarta.validation.Valid;

@Controller
public class UserController {
	List<User> users = new ArrayList<>();
	
	@GetMapping("/add-user-form")
	public String addUserForm(Model model) {
		model.addAttribute("user",new User());
		return "add-user-form";
	}
	
	@PostMapping("/add-user")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-user-form";
		}
		users.add(user);
		model.addAttribute("users",user);
		return "success-user";
	}
}
