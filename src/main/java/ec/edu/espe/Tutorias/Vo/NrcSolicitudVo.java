/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Tutorias.Vo;

import java.io.Serializable;

/**
 *
 * @author wils1
 */
public class NrcSolicitudVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int NRC;
    private String CODIGO;
    private String ASIGNATURA;
    private int CAMPUS;
    private String PERIODO;
    private String NIVEL;

    public NrcSolicitudVo() {
    }

    public NrcSolicitudVo(int NRC, String CODIGO, String ASIGNATURA, int CAMPUS, String PERIODO, String NIVEL) {
        this.NRC = NRC;
        this.CODIGO = CODIGO;
        this.ASIGNATURA = ASIGNATURA;
        this.CAMPUS = CAMPUS;
        this.PERIODO = PERIODO;
        this.NIVEL = NIVEL;
    }

    public int getNRC() {
        return NRC;
    }

    public void setNRC(int NRC) {
        this.NRC = NRC;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getASIGNATURA() {
        return ASIGNATURA;
    }

    public void setASIGNATURA(String ASIGNATURA) {
        this.ASIGNATURA = ASIGNATURA;
    }

    public int getCAMPUS() {
        return CAMPUS;
    }

    public void setCAMPUS(int CAMPUS) {
        this.CAMPUS = CAMPUS;
    }

    public String getPERIODO() {
        return PERIODO;
    }

    public void setPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(String NIVEL) {
        this.NIVEL = NIVEL;
    }
    
    
    
}