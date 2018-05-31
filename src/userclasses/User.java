/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

/**
 *
 * @author Blessing
 */
public class User {

    private String userId;
    private String userEmail;
    private String userImageUrl;
    private String userName;
    private String userSurname;
    private String role;

    public User() {
    }

    public User(String userId, String userEmail, String userImageUrl, String userName, String userSurname, String role) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userImageUrl = userImageUrl;
        this.userName = userName;
        this.userSurname = userSurname;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userEmail=" + userEmail + ", userImageUrl=" + userImageUrl + '}';
    }

}
