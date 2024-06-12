/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int oid;
    private Date oderDate;
    private int userId;
    private User customer;
    private double total_money;
    private int statusId;
    private Status status;

    public Order(int oid, Date oderDate, User customer, double total_money) {
        this.oid = oid;
        this.oderDate = oderDate;
        this.customer = customer;
        this.total_money = total_money;
    }

    public Order(int oid, Date oderDate, int userId, double total_money, int statusId) {
        this.oid = oid;
        this.oderDate = oderDate;
        this.userId = userId;
        this.total_money = total_money;
        this.statusId = statusId;
    }

    public Order(int oid, Date oderDate, int userId, User customer, double total_money, int statusId, Status status) {
        this.oid = oid;
        this.oderDate = oderDate;
        this.userId = userId;
        this.customer = customer;
        this.total_money = total_money;
        this.statusId = statusId;
        this.status = status;
    }

    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
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

    
    
}
