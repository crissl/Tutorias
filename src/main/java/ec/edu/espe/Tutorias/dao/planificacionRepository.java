package ec.edu.espe.Tutorias.dao;

import ec.edu.espe.Tutorias.model.Planificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface planificacionRepository extends JpaRepository<Planificacion, Long>{
	 @Query(value = "SELECT *FROM UZTPLANIF order by CODIGO_UZTPLANIF", nativeQuery = true)
	 List<Planificacion> findallPlanifica();
         //List<Planificacion> findTopByOrderBy();
        Planificacion findTopByOrderByIdDesc();
	 

}
