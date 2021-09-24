package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.edutecno.dto.DireccionDTO;
import cl.edutecno.model.Direccion;
import cl.edutecno.service.DireccionService;

@Controller
@RequestMapping("direcciones")
public class DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	@GetMapping
	public ModelAndView direcciones() {
		ModelAndView modelAndView= new ModelAndView("direcciones");
		modelAndView.addObject("direccion", new Direccion());
		return modelAndView;
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Direccion direccion) {
		DireccionDTO respuestaServicio = direccionService.add(direccion);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/home");
		}else {
			return new RedirectView("/direcciones");
		}
	}
}
