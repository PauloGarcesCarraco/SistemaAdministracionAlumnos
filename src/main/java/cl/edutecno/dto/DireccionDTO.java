package cl.edutecno.dto;

import java.util.List;

import cl.edutecno.model.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DireccionDTO extends GenericDTO{
	public List<Direccion>direcciones;

	public DireccionDTO(List<Direccion>direcciones,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.direcciones= direcciones;
	}
	
	

}
