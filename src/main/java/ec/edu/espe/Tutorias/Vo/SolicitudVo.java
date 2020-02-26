/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Tutorias.Vo;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author wils1
 */
@Service
public class SolicitudVo {

    private static String opciones = "   FROM SIRASGN, SSBSECT, SCBCRSE A ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<NrcVo> getNrc(String q) throws SQLException {
        String opcion = "SELECT DISTINCT SIRASGN_CRN , A.SCBCRSE_SUBJ_CODE,  A.SCBCRSE_CRSE_NUMB , A.SCBCRSE_TITLE , SSBSECT_CAMP_CODE , SSBSECT_TERM_CODE ";
        String were = " AND A.SCBCRSE_EFF_TERM = (SELECT MAX( SCBCRSE_EFF_TERM)  FROM  SCBCRSE  WHERE SCBCRSE_SUBJ_CODE = A.SCBCRSE_SUBJ_CODE  AND SCBCRSE_CRSE_NUMB = A.SCBCRSE_CRSE_NUMB);";
        return jdbcTemplate.query(opcion + opciones + q , new BeanPropertyRowMapper<>(NrcVo.class));
    }

}
