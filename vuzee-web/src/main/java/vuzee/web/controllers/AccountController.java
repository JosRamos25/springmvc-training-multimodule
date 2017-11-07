package vuzee.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vuzee.security.models.AuthenticationUser;
import vuzee.security.models.VuzeeUser;
import vuzee.security.services.EmailExistsException;
import vuzee.security.services.VuzeeUserDetailsService;
import vuzee.web.viewmodels.AccountRegisterViewModel;

@Controller
public class AccountController {
	VuzeeUserDetailsService vuzeeUserDetailsService;

	/**
	 * @param vuzeeUserDetailsService
	 */
	public AccountController(VuzeeUserDetailsService vuzeeUserDetailsService) {
		super();
		this.vuzeeUserDetailsService = vuzeeUserDetailsService;
	}
	@RequestMapping(value = "/account/login")
	public ModelAndView  login(Model model) {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("account/login");
		 mav.addObject("error","true");
		 mav.addObject("authenticationUser", new AuthenticationUser());
		return mav;
	}
	
	@RequestMapping(value = "/account/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("registrationUser", new AccountRegisterViewModel());
		return "account/register";
	}
	
	@RequestMapping(value = "/account/register", method=RequestMethod.POST)
	public String register(@Valid AccountRegisterViewModel registrationUser, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("registrationUser", registrationUser);
            return "account/register";
        }
		VuzeeUser vuzeeUser = new VuzeeUser();
		
		vuzeeUser.setEmail(registrationUser.getEmail());
		vuzeeUser.setFirstName(registrationUser.getFirstName());
		vuzeeUser.setLastName(registrationUser.getLastName());
		vuzeeUser.setPassword(registrationUser.getPassword());
		vuzeeUser.setRepeatPassword(registrationUser.getRepeatPassword());
		
		try {
			vuzeeUserDetailsService.registerNewAccount(vuzeeUser);
		} catch (EmailExistsException e) {
			return register(model);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/account/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/account/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	
}
