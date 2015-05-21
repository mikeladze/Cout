package sout.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ucha on 3/6/15.
 */
@RestController
public class Controller {

	@RequestMapping(value = {"/a", "/s"}, method = RequestMethod.GET)
	public void get() {
		System.out.println("dsadsadsadsadsadsadsadsadsadsadsadsad");
	}

	@RequestMapping(value = {"/controller", "/asd"}, method = RequestMethod.GET)
	public ModelAndView controller(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getAttribute("remoteAddr"));
		System.out.println("this-> " + request.getRemoteHost());
		System.out.println("Controller !!!!!!!!!!!!");

		return new ModelAndView("index");
	}

}
