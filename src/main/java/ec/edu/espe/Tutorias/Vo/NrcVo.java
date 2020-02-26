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
public class NrcVo implements Serializable {

    private static final long serialVersionUID = 1L;
     private int SIRASGN_CRN;
     private int SSBSECT_CAMP_CODE; 
     private int SSBSECT_TERM_CODE; 
    private String SCBCRSE_CRSE_NUMB; 
       
     private String SCBCRSE_TITLE ;
     private String SCBCRSE_SUBJ_CODE;
   
//    private int NRC;
//    private String Asignatura;
//    private int campus;
//    private int periodo;

    public NrcVo() {
    }

    public NrcVo(int SIRASGN_CRN, int SSBSECT_CAMP_CODE, int SSBSECT_TERM_CODE, String SCBCRSE_CRSE_NUMB, String SCBCRSE_TITLE, String SCBCRSE_SUBJ_CODE) {
        this.SIRASGN_CRN = SIRASGN_CRN;
        this.SSBSECT_CAMP_CODE = SSBSECT_CAMP_CODE;
        this.SSBSECT_TERM_CODE = SSBSECT_TERM_CODE;
        this.SCBCRSE_CRSE_NUMB = SCBCRSE_CRSE_NUMB;
        this.SCBCRSE_TITLE = SCBCRSE_TITLE;
        this.SCBCRSE_SUBJ_CODE = SCBCRSE_SUBJ_CODE;
    }

    public int getSIRASGN_CRN() {
        return SIRASGN_CRN;
    }

    public void setSIRASGN_CRN(int SIRASGN_CRN) {
        this.SIRASGN_CRN = SIRASGN_CRN;
    }

    public int getSSBSECT_CAMP_CODE() {
        return SSBSECT_CAMP_CODE;
    }

    public void setSSBSECT_CAMP_CODE(int SSBSECT_CAMP_CODE) {
        this.SSBSECT_CAMP_CODE = SSBSECT_CAMP_CODE;
    }

    public int getSSBSECT_TERM_CODE() {
        return SSBSECT_TERM_CODE;
    }

    public void setSSBSECT_TERM_CODE(int SSBSECT_TERM_CODE) {
        this.SSBSECT_TERM_CODE = SSBSECT_TERM_CODE;
    }

    public String getSCBCRSE_CRSE_NUMB() {
        return SCBCRSE_CRSE_NUMB;
    }

    public void setSCBCRSE_CRSE_NUMB(String SCBCRSE_CRSE_NUMB) {
        this.SCBCRSE_CRSE_NUMB = SCBCRSE_CRSE_NUMB;
    }

    public String getSCBCRSE_TITLE() {
        return SCBCRSE_TITLE;
    }

    public void setSCBCRSE_TITLE(String SCBCRSE_TITLE) {
        this.SCBCRSE_TITLE = SCBCRSE_TITLE;
    }

    public String getSCBCRSE_SUBJ_CODE() {
        return SCBCRSE_SUBJ_CODE;
    }

    public void setSCBCRSE_SUBJ_CODE(String SCBCRSE_SUBJ_CODE) {
        this.SCBCRSE_SUBJ_CODE = SCBCRSE_SUBJ_CODE;
    }


}
