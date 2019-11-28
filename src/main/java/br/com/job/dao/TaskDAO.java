package br.com.job.dao;

import br.com.job.model.Status;
import br.com.job.model.Task;
import br.com.job.model.User;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.UserDataHandler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskDAO {

//    CREATE TABLE IF NOT EXISTS tb_task (
//            id int primary key,
//            description varchar(5000),
//    status int not null default 0,
//    hoursToSpend int,
//    hoursSpent int,
//    assignee int,
//    iniDate date,
//    endDate date,
//    sprint int
//);

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();

        DBConnection con = new DBConnection();
        try {
            String query = "SELECT id, title, description, status, hoursToSpend, hoursSpent, assignee, iniDate, endDate FROM tb_task;";

            PreparedStatement ps = con.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task t = new Task();

                t.setId(rs.getInt(1));
                t.setTitle(StringUtils.defaultString(rs.getString(2)));
                t.setDescription(StringUtils.defaultString(rs.getString(3)));
                t.setStatus(Status.valueOf(StringUtils.defaultString(rs.getString(4))));
                t.setHoursToSpend(rs.getInt(5));
                t.setHoursSpent(rs.getInt(6));
                t.setAssignee(new UserDAO().getUser(rs.getString(7)));
                t.setIniDate(rs.getDate(8));
                t.setEndDate(rs.getDate(9));

                tasks.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.closeCon();
        return tasks;
    }

    public void saveTask(Task t, boolean isUpdate){
        DBConnection con = new DBConnection();
        try {
            String query;
            if(isUpdate)
                query = "UPDATE tb_task set " +
                        " title = ?, description = ?, status = ?, hoursToSpend = ?, hoursSpent = ?, assignee = ?, iniDate = ?, endDate = ?" +
                        " where id = " + t.getId();
            else
                query = "INSERT INTO tb_task (title, description, status, hoursToSpend, hoursSpent, assignee, iniDate, endDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.getCon().prepareStatement(query);

            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getStatus().name());
            ps.setInt(4, t.getHoursToSpend());
            ps.setInt(5, t.getHoursSpent());
            ps.setInt(6, 1);
            ps.setDate(7, new java.sql.Date(t.getIniDate().getTime()));
            ps.setDate(8, new java.sql.Date(t.getEndDate().getTime()));

            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
