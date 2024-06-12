/*;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Admin
 */
public class UserDao extends DBContext {

    public User getUser(String userName, String pass) {
        User u = null;
        try {
            String sql = "select * from Users u where u.user_name = ? and u.pass_word = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Role r = getRoleById(rs.getInt(4));
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }

    public List<User> getUsers() {
        List<User> listu = new ArrayList<>();
        User u;
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = getRoleById(rs.getInt(4));
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), r, rs.getInt(5));
                listu.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listu;
    }

    public User getUserById(int id) {
        User u = null;
        try {
            String sql = "select * from Users u where u.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = getRoleById(rs.getInt(4));
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), r);
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }

    public boolean addUser(User u) {
        try {
            String sql = "INSERT INTO Users ([user_name], [email], [pass_word], role_id, [status]) VALUES"
                    + "values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getRoleId());
            ps.setInt(5, u.getStatusId());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    private Role getRoleById(int roleid) {
        Role r = null;
        try {
            String sql = "select * from Roles r where r.role_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new Role(rs.getInt(1), rs.getString(2));
                return r;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }

    public List<Role> getAllRole() {
        List<Role> listr = new ArrayList<>();
        try {
            String sql = "select * from Roles";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role(rs.getInt(1), rs.getString(2));
                listr.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listr;
    }

    

    public boolean updateUser(User user) {
        try {
            String sql = "update Users set password = ?, role_id = ?, status = ? where Users.user_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getRoleId());
            ps.setInt(3, user.getStatusId());
            ps.setString(4, user.getUserName());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addRole(Role role) {
        try {
            String sql = "insert into [Role](roleid, rolename)"
                    + "values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getRoleName());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

}
