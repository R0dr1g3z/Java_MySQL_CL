package com.example.javamysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main11 {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM cinemas JOIN movies";
        int memory = 0;
        try (PreparedStatement preparedStatement = DbUtil.connect("cinemas_ex2").prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (memory != resultSet.getInt("cinema_id")) {
                    System.out.println("Cinema id: " + resultSet.getString("cinema_id"));
                    System.out.println("* Movie id: " + resultSet.getString("movie_id"));
                    memory = resultSet.getInt("cinema_id");
                }
                System.out.println("* Movie id: " + resultSet.getInt("movie_id"));
            }
        }
    }
}