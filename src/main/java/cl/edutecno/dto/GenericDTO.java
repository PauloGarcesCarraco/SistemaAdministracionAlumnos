package cl.edutecno.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//anotaciones lombok
//para la creacion del objeto completo
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericDTO {
	
	String mensaje;
	String codigo;
}
