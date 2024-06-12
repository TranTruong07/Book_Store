/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class User {
    private String userName;
    private String email;
    private String password;
    private int roleId;
    private Role r;
    private int statusId;
    private Status status;

    public User(String userName, String email, String password, int roleId, int statusId) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.statusId = statusId;
    }

    public User(String userName, String email, String password, Role r, int statusId) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.r = r;
        this.statusId = statusId;
    }

    public User(String userName, String email, String password, Role r) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.r = r;
    }

   

     public User() {
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
