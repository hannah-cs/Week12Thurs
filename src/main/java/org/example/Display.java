package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Display {
    public void displayAll(String table) {
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connected to the database successfully. All customers:");
            String query = "";
            if (table.equals("courses")) {
                query = "SELECT * FROM courses;";
                try (PreparedStatement pst = connection.prepareStatement(query);
                     ResultSet rs = pst.executeQuery()) {
                    System.out.println();
                    while (rs.next()) {
                        System.out.println("Course ID: " + rs.getInt("ID"));
                        System.out.println("Course name: " + rs.getString("CourseName"));
                        System.out.println("Description: " + rs.getString("CourseDescription"));
                        System.out.println();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (table.equals("themes")) {
                query = "SELECT * FROM themes;";
                try (PreparedStatement pst = connection.prepareStatement(query);
                     ResultSet rs = pst.executeQuery()) {
                    System.out.println();
                    while (rs.next()) {
                        System.out.println("Theme ID: " + rs.getInt("ID"));
                        System.out.println("Theme name: " + rs.getString("ThemeName"));
                        System.out.println("Course ID: " + rs.getInt("CourseId"));
                        System.out.println();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseManager.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}