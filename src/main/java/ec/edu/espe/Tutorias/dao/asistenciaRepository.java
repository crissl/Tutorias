package ec.edu.espe.Tutorias.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.espe.Tutorias.model.Asistencia;
import ec.edu.espe.Tutorias.model.Planificacion;

public interface asistenciaRepository extends JpaRepository<Asistencia, Long>{
	 @Query(value = "SELECT *FROM UZTASISTENTES order by UZTASISTENTES_CODIGO", nativeQuery = true)
	 List<Asistencia> findallAsiste();
         //List<Planificacion> findTopByOrderBy();
	 Asistencia findTopByOrderByIdDesc();
	
	 


}
