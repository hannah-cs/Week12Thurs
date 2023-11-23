package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public void insertInto(String table, String content) {
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connected to the database successfully.");
            String query = "";
            if (table.equals("courses")) {
                query = "INSERT INTO courses (ID, CourseName, CourseDescription) VALUES (" + content + ");";
            } else if (table.equals("themes")){
                query = "INSERT INTO themes (ID, ThemeName, CourseId) VALUES (" + content + ");";
            }
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(table+" updated successfully.");
                } else {
                    System.out.println("Failed to create customer.");
                }
                DatabaseManager.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}
