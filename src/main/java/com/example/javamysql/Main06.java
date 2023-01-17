package com.example.javamysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main06 {
    public static void main(String[] args) throws SQLException {
        printMovies();
    }

    public static void printMovies() throws SQLException {
        try (Connection connect = DbUtil.connect("cinemas_ex2")) {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT AVG(rating) FROM movies;");
            ResultSet resultset = preparedStatement.executeQuery();
            String data = "";
            while (resultset.next()) {
                data = String.valueOf(resultset.getDouble(1));
            }
            DbUtil.printData(DbUtil.connect("cinemas_ex2"), "SELECT * FROM movies WHERE rating > ?".replace("?", data),
                    "title");
        }
    }
}
