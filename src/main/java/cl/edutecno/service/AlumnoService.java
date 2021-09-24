package cl.edutecno.service;

import cl.edutecno.dto.AlumnoDTO;
import cl.edutecno.model.Alumno;

public interface AlumnoService {
	public AlumnoDTO findAll();
	public AlumnoDTO add(Alumno alumno);

}
