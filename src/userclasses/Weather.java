/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import ca.weblite.codename1.json.JSONObject;

/**
 *
 * @author sandraarnolds
 */
public class Weather {

    private String description;
    private String id;
    private String name;
    private String temp;
    private String temp_min;
    private String humidity;
    private String temp_max;

    public Weather() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public String toString() {
        return "Weather{" + "description=" + description + ", id=" + id + ", name=" + name + ", temp=" + temp + ", temp_min=" + temp_min + ", humidity=" + humidity + ", temp_max=" + temp_max + '}';
    }

}
