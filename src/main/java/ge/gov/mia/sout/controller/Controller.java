package ge.gov.mia.sout.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ucha on 3/6/15.
 */
@RestController
public class Controller {

	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	public void controller(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getAttribute("remoteAddr"));
		System.out.println("this-> " + request.getRemoteHost());
		System.out.println("Controller !!!!!!!!!!!!");
	}

}
