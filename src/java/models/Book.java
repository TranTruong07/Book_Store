/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Book {
    private int id;
    private String name;
    private int price;
    private String author;
    private int quantity;
    private String description;
    private String imgname;
    private int categoryId;
    private Category c;
    private int statusId;
    private Status status;

    public Book() {
    }

    public Book(int id, String name, int price, String author, int quantity, String description, String imgname, int categoryId, int statusId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.description = description;
        this.imgname = imgname;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Book(int id, String name, int price, String author, int quantity, String description, String imgname, int categoryId, Category c) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.description = description;
        this.imgname = imgname;
        this.categoryId = categoryId;
        this.c = c;
    }

//    public Book(int id, String name, double price, String author, int quantity, String description, String imgname, int categoryId, int statusId) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.author = author;
//        this.quantity = quantity;
//        this.description = description;
//        this.imgname = imgname;
//        this.categoryId = categoryId;
//        this.statusId = statusId;
//    }

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

    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    
    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }
    
    
}
