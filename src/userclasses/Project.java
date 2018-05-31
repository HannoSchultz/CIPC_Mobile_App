/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.parse4cn1.ParseObject;
import java.util.Date;

/**
 *
 * @author mLab
 */
public class Project {

    private int id;
    private int userId;
    private String objectId;
    private String title;
    private Date date;
    private String description;
    private ParseObject parseObject;

    public Project() {
    }

    public Project(int userId, int id, String title, Date date, String description) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public ParseObject getParseObject() {
        return parseObject;
    }

    public void setParseObject(ParseObject parseObject) {
        this.parseObject = parseObject;
    }

}
