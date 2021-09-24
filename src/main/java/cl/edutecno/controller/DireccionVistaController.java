package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.edutecno.service.DireccionService;

@Controller
@RequestMapping("direccioneslista")
public class DireccionVistaController {
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping
	public ModelAndView DireccionesLista() {
		ModelAndView modelAndView = new ModelAndView("direccioneslista");
		modelAndView.addObject("direccion", direccionService.findAll().getDirecciones());
		return modelAndView;
	}
	

}
