/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.pojos;

/**
 *
 * @author HanSchultz
 */
public class AnnualReturns {

    String ent_tel_code;
    String ent_tel_no;
    String ent_cell;
    String ent_email;
    String ent_website;
    String bus_desc;
    String princ_bus_place;

    public String getEnt_tel_code() {
        return ent_tel_code;
    }

    public void setEnt_tel_code(String ent_tel_code) {
        this.ent_tel_code = ent_tel_code;
    }

    public String getEnt_tel_no() {
        return ent_tel_no;
    }

    public void setEnt_tel_no(String ent_tel_no) {
        this.ent_tel_no = ent_tel_no;
    }

    public String getEnt_cell() {
        return ent_cell;
    }

    public void setEnt_cell(String ent_cell) {
        this.ent_cell = ent_cell;
    }

    public String getEnt_email() {
        return ent_email;
    }

    public void setEnt_email(String ent_email) {
        this.ent_email = ent_email;
    }

    public String getEnt_website() {
        return ent_website;
    }

    public void setEnt_website(String ent_website) {
        this.ent_website = ent_website;
    }

    public String getBus_desc() {
        return bus_desc;
    }

    public void setBus_desc(String bus_desc) {
        this.bus_desc = bus_desc;
    }

    public String getPrinc_bus_place() {
        return princ_bus_place;
    }

    public void setPrinc_bus_place(String princ_bus_place) {
        this.princ_bus_place = princ_bus_place;
    }

    @Override
    public String toString() {
        return "AnnualReturns{" + "ent_tel_code=" + ent_tel_code + ", ent_tel_no=" + ent_tel_no + ", ent_cell=" + ent_cell + ", ent_email=" + ent_email + ", ent_website=" + ent_website + ", bus_desc=" + bus_desc + ", princ_bus_place=" + princ_bus_place + '}';
    }

   
    

}
