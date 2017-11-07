package vuzee.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VuzeeErrorController  implements ErrorController {

	 private static final String PATH = "/error";

	    @Autowired
	    private ErrorAttributes errorAttributes;

	    @RequestMapping(value = PATH)
	    public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
	    	getErrorAttributes(request, true);
	        ModelAndView mav = new ModelAndView("error");
	        response.getStatus();
	        mav.addObject("errorStatus",response.getStatus());
	        mav.addObject("errors", getErrorAttributes(request, true));
	        return mav;
	    }
	 
	    
		@Override
		public String getErrorPath() {
			// TODO Auto-generated method stub
			return PATH;
		}
		
		private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
	        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
	        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	    }

}
