package cl.edutecno.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SQ_ALUMNO", initialValue = 1, allocationSize = 1)
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ALUMNO")
	private Integer id;
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private Integer edad;
	private String fechaIngreso;
	@OneToOne
	@JoinColumn(name = "direccion_id", referencedColumnName = "id")
	private Direccion direccion;
	

}
