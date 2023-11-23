package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public void updateCourse(int ID, String name, String description) {
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connected to the database successfully.");
            String query = "UPDATE courses SET CourseName = ?, CourseDescription = ? WHERE id = " + ID;
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, name);
                pst.setString(2, description);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Course updated successfully.");
                } else {
                    System.out.println("Failed to update course.");
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

    public void updateTheme(int ID, String name, int courseId) {
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connected to the database successfully.");
            String query = "UPDATE themes SET ThemeName = ?, courseId = ? WHERE id = " + ID;
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, name);
                pst.setInt(2, courseId);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Theme updated successfully.");
                } else {
                    System.out.println("Failed to update theme.");
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