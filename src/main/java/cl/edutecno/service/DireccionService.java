package cl.edutecno.service;

import cl.edutecno.dto.DireccionDTO;
import cl.edutecno.model.Direccion;

public interface DireccionService {
	
	public DireccionDTO findAll();
	public DireccionDTO add(Direccion direccion);

}
