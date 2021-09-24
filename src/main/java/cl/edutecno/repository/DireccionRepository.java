package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}
