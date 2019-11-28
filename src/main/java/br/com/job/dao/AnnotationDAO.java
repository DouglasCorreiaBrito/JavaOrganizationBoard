package br.com.job.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.job.model.Annotation;

//CREATE TABLE IF NOT EXISTS tb_annotation (
//    id int auto_increment primary key,
//    description varchar(5000),
//    title varchar(30) not null,
//    color varchar(6),
//    expireDate date
//);

public class AnnotationDAO {

    public List<Annotation> getAnnotations() {
        List<Annotation> annotations = new ArrayList<>();

        DBConnection con = new DBConnection();
        try {
            String query = "SELECT id, title, description, expireDate FROM tb_annotation;";

            PreparedStatement ps = con.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Annotation t = new Annotation();

                t.setId(rs.getInt(1));
                t.setTitle(StringUtils.defaultString(rs.getString(2)));
                t.setDescription(StringUtils.defaultString(rs.getString(3)));
                t.setExpireDate(rs.getDate(4));

                annotations.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.closeCon();
        return annotations;
    }

    public void saveAnnotation(Annotation a, boolean isUpdate){
        DBConnection con = new DBConnection();
        try {
            String query;
            if(isUpdate)
                query = "UPDATE tb_Annotation set " +
                        " title = ?, description = ?, expireDate = ?" +
                        " where id = " + a.getId();
            else
                query = "INSERT INTO tb_Annotation (title, description, expireDate) VALUES(?, ?, ?)";
            PreparedStatement ps = con.getCon().prepareStatement(query);

            ps.setString(1, a.getTitle());
            ps.setString(2, a.getDescription());
            ps.setDate(3, new java.sql.Date(a.getExpireDate().getTime()));

            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
