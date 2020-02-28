package ec.edu.espe.Tutorias.dao;

import ec.edu.espe.Tutorias.models.Planificacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface planificacionRepository extends CrudRepository<Planificacion, Long>{
	 @Query(value = "SELECT *FROM UZTPLANIF order by CODIGO_UZTPLANIF", nativeQuery = true)
	 List<Planificacion> findallPlanifica();
	 
	 

}
