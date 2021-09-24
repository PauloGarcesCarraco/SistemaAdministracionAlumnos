package cl.edutecno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SQ_DIRECCION", initialValue = 1, allocationSize = 1)
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION")
	private Integer id;
	private String calle;
	private Integer numero;
	private String ciudad;
	private TipoDireccion tipo;
	
	

}
