/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

/**
 *
 * @author HanSchultz
 */
public class DHA_Detail {

    private String IDNUMBER;
    private String SURNAME;
    private String NAMES;
    private String DEATH_STATUS;
    private String DOB;
    private String ADDR_LINE1;
    private String ADDR_LINE2;
//private String deathdate;

    public String getIDNUMBER() {
        return IDNUMBER;
    }

//    public String getDeathdate() {
//        return deathdate;
//    }
//
//    public void setDeathdate(String deathdate) {
//        this.deathdate = deathdate;
//    }
    public void setIDNUMBER(String IDNUMBER) {
        this.IDNUMBER = IDNUMBER;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public String getNAMES() {
        return NAMES;
    }

    public void setNAMES(String NAMES) {
        this.NAMES = NAMES;
    }

    public String getDEATH_STATUS() {
        return DEATH_STATUS;
    }

    public void setDEATH_STATUS(String DEATH_STATUS) {
        this.DEATH_STATUS = DEATH_STATUS;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getADDR_LINE1() {
        return ADDR_LINE1;
    }

    public void setADDR_LINE1(String ADDR_LINE1) {
        this.ADDR_LINE1 = ADDR_LINE1;
    }

    public String getADDR_LINE2() {
        return ADDR_LINE2;
    }

    public void setADDR_LINE2(String ADDR_LINE2) {
        this.ADDR_LINE2 = ADDR_LINE2;
    }

}
