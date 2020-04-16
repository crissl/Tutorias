package ec.edu.espe.Tutorias.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.edu.espe.Tutorias.model.Asistencia;


@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
	 @Query(value = "SELECT * FROM UZTASISTENTES order by UZTASISTENTES_CODIGO", nativeQuery = true)
	 List<Asistencia> findallAsiste();
         //List<Planificacion> findTopByOrderBy();
	 Asistencia findTopByOrderByIdDesc();
	 
	 Asistencia findByCodigoPlanificacionAndPidm(int planif,int pidm);
	
	 //findByPerIdAndUsuId

	 
	 
	 

}
