package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.edutecno.service.AlumnoService;
import cl.edutecno.service.DireccionService;

@Controller
public class HomeController {
	
	@Autowired
	private AlumnoService alumnoService;
	private DireccionService direccionService;
	
	@GetMapping({"/","home"})
	public ModelAndView alumnos() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("alumnos", alumnoService.findAll().getAlumnos());
		return modelAndView;
	}

}
