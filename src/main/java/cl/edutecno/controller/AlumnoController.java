package cl.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.edutecno.dto.AlumnoDTO;
import cl.edutecno.model.Alumno;
import cl.edutecno.service.AlumnoService;
import cl.edutecno.service.DireccionService;

@Controller
@RequestMapping("alumnos")
public class AlumnoController {
	private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);
	
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping
	public ModelAndView alumnos(Model model) {
		ModelAndView modelAndView = new ModelAndView("alumnos");
		modelAndView.addObject("alumno", new Alumno());
		model.addAttribute("direcciones", direccionService.findAll().getDirecciones());
		return modelAndView;
		
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Alumno alumno) {
		AlumnoDTO respuestaServicio= alumnoService.add(alumno);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/home");
		}else {
			return new RedirectView("/alumnos");
		}
	}

}
