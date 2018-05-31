/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.parse4cn1.ParseObject;
import com.parse4cn1.ParseUser;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author mLab
 */
public class Task {

    private String objectId;
    private int id;
    private int userId;
    private String title;
    private Date date;
    private String status;
    private ParseObject parseObject;
    private HashMap<String, ParseObject> taskUsers;

    public Task() {
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "Task{" + "title=" + title + '}';
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

    public ParseObject getParseObject() {
        return parseObject;
    }

    public void setParseObject(ParseObject parseObject) {
        this.parseObject = parseObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, ParseObject> getTaskUsers() {
        return taskUsers;
    }

    public void setTaskUsers(HashMap<String, ParseObject> taskUsers) {
        this.taskUsers = taskUsers;
    }

}
