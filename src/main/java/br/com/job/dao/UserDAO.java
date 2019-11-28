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

    public User getUser(String userId) {
        DBConnection con = new DBConnection();
        User user = new User();
        try {
            String query = "SELECT id, username, userlogin, userpassword, imageview FROM tb_user where id = ?;";

            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(StringUtils.defaultString(rs.getString(2)));
                user.setUsername(StringUtils.defaultString(rs.getString(3)));
                user.setPassword(StringUtils.defaultString(rs.getString(4)));
                user.setProfileImage(StringUtils.defaultString(rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.closeCon();
        return user;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        DBConnection con = new DBConnection();
        try {
            String query = "SELECT id, username, userlogin, userpassword, id FROM tb_user;";

            PreparedStatement ps = con.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();

                u.setId(rs.getInt(1));
                u.setName(StringUtils.defaultString(rs.getString(2)));
                u.setUsername(StringUtils.defaultString(rs.getString(3)));
                u.setPassword(StringUtils.defaultString(rs.getString(4)));
                try {
                    u.setProfileImage(StringUtils.defaultString(rs.getString(5)) + ".png");
                } catch (Exception e) {
                    u.setProfileImage("profilewhite.png");
                }
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.closeCon();
        return users;
    }

    public int insertUser(User u){
        DBConnection con = new DBConnection();
        int insertedId = 0;
        try {
            String query = "INSERT INTO tb_user (username, userlogin, userpassword) VALUES(?, ?, ?)";
            PreparedStatement ps = con.getCon().prepareStatement(query);

            ps.setString(1, u.getName());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());

            ps.executeUpdate();

            query = "SELECT LAST_INSERT_ID()";
            ps = con.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                insertedId = rs.getInt(1);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        con.closeCon();
        return insertedId;
    }

}
