package com.anekdotchik.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.anekdotchik.blog.dao.UserDAO;
import com.anekdotchik.blog.impl.persistence.UserImpl;
import com.anekdotchik.blog.persistence.User;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
	@Autowired(required = true)
	private UserDAO userDAO;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("login") String login,
			@RequestParam("password") String password) {
		User user = new UserImpl();
		user.setLogin(login);
		user.setPassword(password);
		userDAO.save(user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", login);
		mav.setViewName("redirect:view");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "user/create";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("login") String login,
			@RequestParam("password") String password) {
		User user = new UserImpl();
		user.setLogin(login);
		user.setPassword(password);
		userDAO.save(user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", login);
		mav.setViewName("redirect:view");
		return mav;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@ModelAttribute("login") String login, Model model) {
		User user = userDAO.findUserByLogin(login);
		model.addAttribute("id", user.getId());
		model.addAttribute("login", user.getLogin());
		model.addAttribute("password", user.getPassword());
		return "user/view";
	}

}
