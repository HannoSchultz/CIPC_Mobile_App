/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.pojos;

/**
 *
 * @author Blessing.Mahlalela
 */
public class Dashboard {

    String button_name;
    String b_visible;

    public String getButton_name() {
        return button_name;
    }

    public void setButton_name(String button_name) {
        this.button_name = button_name;
    }

    public String getB_visible() {
        return b_visible;
    }

    public void setB_visible(String b_visible) {
        this.b_visible = b_visible;
    }

    @Override
    public String toString() {
        return "Dashboard{" + "button_name=" + button_name + ", b_visible=" + b_visible + '}';
    }

}
