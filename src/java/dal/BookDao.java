/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Book;
import models.Category;

/**
 *
 * @author Admin
 */
public class BookDao extends DBContext {

    public boolean updateBook(int id, Book b) {
        try {
            String sql = "update Products set name = ?, price = ?, author = ?, categoryid = ?, quantity = ?, imgname = ? where Products.productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setInt(2, b.getPrice());
            ps.setString(3, b.getAuthor());
            if (b.getC().getId() == 0) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, b.getC().getId());
            }
            ps.setInt(5, b.getQuantity());
            ps.setString(6, b.getImgname());
            ps.setInt(7, id);

            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public List<Book> getAllBook() {
        List<Book> listb = new ArrayList<>();
        try {
            String sql = "select * from Products p where p.status = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String author = rs.getString(4);
                int quantity = rs.getInt(5);
                String description = rs.getString(6);
                String imgname = rs.getString(7);
                int categoryId = rs.getInt(8);
                int statusId = rs.getInt(9);
                Book b = new Book(pid, name, price, author, quantity, description, imgname, categoryId, statusId);
                listb.add(b);
            }
            if(!listb.isEmpty()){
                for(Book b : listb){
                    b.setC(getCategoryById(b.getCategoryId()));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listb;
    }

    public boolean addBook(Book b) {
        try {
            String sql = "INSERT INTO Products ([name], price, author, quantity, [description], img, category_id, [status]) VALUES"
                    + "(?,?,?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setInt(2, b.getPrice());
            ps.setString(3, b.getAuthor());
            ps.setInt(4, b.getQuantity());
            ps.setString(5, b.getDescription());
            ps.setString(6, b.getImgname());
            ps.setInt(7, b.getCategoryId());
            ps.setInt(8, b.getStatusId());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public List<Category> getAllCategory() {
        List<Category> listc = new ArrayList<>();
        try {
            String sql = "select * from Categories where [status] = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int status = rs.getInt(3);
                Category c = new Category(id, name, status);
                listc.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listc;
    }

    public Category getCategoryById(int categoryId) {
        Category c = null;
        try {
            String sql = "select * from Categories where [status] = 1 and category_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
    }

    public List<Book> getBookByCategoryId(int id) {
        List<Book> listb = new ArrayList<>();
        try {
            String sql = "select * from Products p where p.category_id = ? and p.status = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String author = rs.getString(4);
                int quantity = rs.getInt(5);
                String description = rs.getString(6);
                String imgname = rs.getString(7);
                int categoryId = rs.getInt(8);
                int statusId = rs.getInt(9);
                Book b = new Book(pid, name, price, author, quantity, description, imgname, categoryId, statusId);
                listb.add(b);
            }
            if(!listb.isEmpty()){
                for(Book b : listb){
                    b.setC(getCategoryById(b.getCategoryId()));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listb;
    }

    public boolean addCategory(String categoryname) {
        try {
            String sql = "INSERT INTO Categories (name, [status]) VALUES"
                    + "  (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, categoryname);
            ps.setInt(2, 1);
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Book getBookById(int bid) {
        try {
            String sql = "select * from Products p where p.product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String author = rs.getString("author");
                Category c = getCategoryById(rs.getInt("category_id"));
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                String imgname = rs.getString("img");
                int statusId = rs.getInt("status");
                Book b = new Book(pid, name, price, author, quantity, description, imgname, statusId, statusId);
                b.setC(c);
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
