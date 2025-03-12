package org.example.Services;

import org.example.Model.Task;
import org.example.Repository.TaskManagerRepo;
import org.example.db.ConnectionDb;

import java.sql.*;

public class TaskManagerImp implements TaskManagerRepo {

    ConnectionDb db  = new ConnectionDb();

    @Override
    public void Save(Task task) {

        try (Connection conn = db.Connection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO task (description, status, created, updated) VALUES (?,?,?,?)")) {

                pstmt.setString(1, task.getDescription());
                pstmt.setString(2, task.getStatus());
                pstmt.setString(3, task.getCreated());
                pstmt.setString(4, task.getUpdated());

                pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage() + " ? ");
        }

    }

    @Override
    public void FindAll() {
        try (Connection conn = db.Connection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM task");

            while (rs.next()){
                 System.out.println(
                         "id: " + rs.getInt("id") + ", " +
                         "description: " + rs.getString("description") + ", " +
                         "status: " +  rs.getString("status") + ", " +
                         "created: " + rs.getString("created")+ ", " +
                         "updated: " +  rs.getString("updated")
                 );
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void FindByStatus(String status) {
        try (Connection conn = db.Connection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM task WHERE status = ?")) {
                pstmt.setString(1,status);
                try {
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()){
                        System.out.println(
                                "id: " + rs.getInt("id") + ", " +
                                        "description: " + rs.getString("description") + ", " +
                                        "status: " +  rs.getString("status") + ", " +
                                        "created: " + rs.getString("created")+ ", " +
                                        "updated: " +  rs.getString("updated")
                        );
                    }

                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void UpdateDescription(String description, int id) {
        try (Connection conn = db.Connection();
             var pstmt = conn.prepareStatement("UPDATE task SET description = ? WHERE id = ?")){

            pstmt.setString(1, description);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void MarkAs(String status, int id) {
        try (Connection conn = db.Connection();
             var pstmt = conn.prepareStatement("UPDATE task SET status = ? WHERE id = ? ")){

            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void Delete(int id) {
        try (Connection conn = db.Connection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM task WHERE id = ?")) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void UpdateDateTime(int id, String dateTime){
        try (Connection conn = db.Connection();
             var pstmt = conn.prepareStatement("UPDATE task SET updated = ? WHERE id = ? ")){

            pstmt.setString(1, dateTime);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

