package pe.edu.upn.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.model.entity.Especialidad;
@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,String>{

}
