package com.example.javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil extends DbUtilData {
    public static Connection connect(String database) throws SQLException {
        String connStr = String.format("%s/%s?useSSL=false&characterSet=utf8mb4&serverTimezone=UTC", DB_URL, database);
        Connection connection = DriverManager.getConnection(connStr, DB_USER, DB_PASS);
        return connection;
    }

    public static void insert(Connection conn, String query, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String DELETE_QUERY = "DELETE FROM tableName WHERE id = ?";

public static void remove(Connection conn, String tableName, int id) {
    try (PreparedStatement statement = 
                    conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}