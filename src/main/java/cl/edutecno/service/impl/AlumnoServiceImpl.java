package cl.edutecno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.AlumnoDTO;
import cl.edutecno.model.Alumno;
import cl.edutecno.repository.AlumnoRepository;
import cl.edutecno.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	private static final Logger log = LoggerFactory.getLogger(AlumnoServiceImpl.class);

	@Autowired
	private AlumnoRepository daoAlumno;
	private AlumnoDTO respuestaAlumno;
	
	
	@Override
	@Transactional(readOnly = true)
	public AlumnoDTO findAll() {
		respuestaAlumno= new AlumnoDTO(new ArrayList<Alumno>(),"Ha ocurrido un error", "101");
		try {
			respuestaAlumno.setAlumnos((List<Alumno>)daoAlumno.findAll());
			respuestaAlumno.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuestaAlumno.getAlumnos().size()));
			respuestaAlumno.setCodigo("0");
		} catch (Exception e) {
			log.trace("AlumnoService: error en findAll()",e);
		}
		return respuestaAlumno;
	}

	@Override
	@Transactional
	public AlumnoDTO add(Alumno alumno) {
		respuestaAlumno= new AlumnoDTO(new ArrayList<Alumno>(), "Ha ocurrido un error", "102");
		try {
			daoAlumno.save(alumno);
			respuestaAlumno.setMensaje(String.format("Se ha guardado correctamente el alumno %s", alumno.getNombre() +" "+ alumno.getApellido()));
			respuestaAlumno.setCodigo("0");
		} catch (Exception e) {
			log.trace("AlumnoService: error en add()",e);
		}
		return respuestaAlumno;
	}

}
