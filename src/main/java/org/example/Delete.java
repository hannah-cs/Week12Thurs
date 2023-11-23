package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public void deleteFrom(String table, int ID) {
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connected to the database successfully.");
            String query = "DELETE FROM "+table+" WHERE id = "+ID;
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Entry "+ID+" successfully deleted from "+table);
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