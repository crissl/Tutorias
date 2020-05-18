package ec.edu.espe.Tutorias.dao;

import ec.edu.espe.Tutorias.Vo.EnvioCorreoVo;
import ec.edu.espe.Tutorias.model.Planificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;

@Repository
public interface PlanificacionRepository extends JpaRepository<Planificacion, Long>{
	 @Query(value = "SELECT *FROM UZTPLANIF order by CODIGO_UZTPLANIF", nativeQuery = true)
	 List<Planificacion> findallPlanifica();
         //List<Planificacion> findTopByOrderBy();
        Planificacion findTopByOrderByIdDesc();
        Planificacion findById (int id);
	
        @Query(value = "{call wfobjects.wzwkreport.P_Envio_Emails(:par_mensaje, :par_emailp,:par_mensajeprincipal,:par_notificacion1,:par_notificacion2,:Email,:Cedula,:Nombres)}", nativeQuery = true)
    	public List<EnvioCorreoVo> findAllBetweenStoredProcedure(
    			@Param("par_mensaje") String par_mensaje,
    			@Param("par_emailp") String par_emailp,
    			@Param("par_mensajeprincipal") String par_mensajeprincipal,
        		@Param("par_notificacion1") String par_notificacion1,
        		@Param("Email") String Email,
        		@Param("Cedula") String Cedula,
        		@Param("Nombres") String Nombres,
        		@Param("par_notificacion2") String par_notificacion2);


}
