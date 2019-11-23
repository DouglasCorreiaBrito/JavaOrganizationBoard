package br.com.job.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.job.model.User;
import org.apache.commons.lang3.StringUtils;

public class UserDAO {

    public static List<User> users = new ArrayList<User>();

    public void saveUser(User usuario) {
        users.add(usuario);
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        DBConnection con = new DBConnection();
        try {
            String query = "SELECT id, username, userlogin, userpassword, imageview FROM tb_user;";

            PreparedStatement ps = con.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();

                u.setId(rs.getInt(1));
                u.setName(StringUtils.defaultString(rs.getString(2)));
                u.setUsername(StringUtils.defaultString(rs.getString(3)));
                u.setPassword(StringUtils.defaultString(rs.getString(4)));
                u.setProfileImage(StringUtils.defaultString(rs.getString(5)));

                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.closeCon();
        return users;
    }

    public void insertUser(User u){
        DBConnection con = new DBConnection();
        try {
            String query = "INSERT INTO tb_user (username, userlogin, userpassword, imageview) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.getCon().prepareStatement(query);

            ps.setString(1, u.getName());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, "pp.jfif");

            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
