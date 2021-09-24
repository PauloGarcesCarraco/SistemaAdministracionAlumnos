package cl.edutecno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.DireccionDTO;
import cl.edutecno.model.Direccion;
import cl.edutecno.repository.DireccionRepository;
import cl.edutecno.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{
	
	private static final Logger log = LoggerFactory.getLogger(DireccionServiceImpl.class);
	
	@Autowired
	private DireccionRepository daoDireccion;
	private DireccionDTO respuestaDireccion;
	

	@Override
	@Transactional(readOnly = true)
	public DireccionDTO findAll() {
		respuestaDireccion= new DireccionDTO(new ArrayList<Direccion>(),"Ha ocurrido un error", "201");
		try {
			respuestaDireccion.setDirecciones((List<Direccion>)daoDireccion.findAll()); 
			respuestaDireccion.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuestaDireccion.getDirecciones().size()));
			respuestaDireccion.setCodigo("0");
		} catch (Exception e) {
			log.trace("Direccion Service: Error en findAll", e);
		}
	
		return respuestaDireccion;
	}

	@Override
	public DireccionDTO add(Direccion direccion) {
		respuestaDireccion= new DireccionDTO(new ArrayList<Direccion>(),"Ha ocurrido un error", "202");
		try {
			daoDireccion.save(direccion);
			respuestaDireccion.setMensaje(String.format("Se ha guardado correctamente la direccion %s", direccion.getCalle() +", "+direccion.getCiudad()));
			respuestaDireccion.setCodigo("0");
		} catch (Exception e) {
			log.trace("Direccion Service: Error en add", e);
		}
		return respuestaDireccion;
	}

}
