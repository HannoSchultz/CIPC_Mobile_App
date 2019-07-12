/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.xml.Element;

/**
 *
 * @author Administrator
 */
public class BEEDetail {

    private String ent_no;
    private String ent_name;

    public String getBee_can_file() {
        return bee_can_file;
    }

    public void setBee_can_file(String bee_can_file) {
        this.bee_can_file = bee_can_file;
    }

    public String getBee_date() {
        return bee_date;
    }

    public void setBee_date(String bee_date) {
        this.bee_date = bee_date;
    }
    private String bee_can_file;
    private String bee_date;

    public String getEnt_no() {
        return ent_no;
    }

    public void setEnt_no(String ent_no) {
        this.ent_no = ent_no;
    }

    public String getEnt_name() {
        return ent_name;
    }

    public void setEnt_name(String ent_name) {
        this.ent_name = ent_name;
    }
    
    
               
}
