package com.example.javamysql;

import java.sql.SQLException;

public class Main04 {
    public static void main(String[] args) throws SQLException {
        DbUtil.printData(DbUtil.connect("cinemas_ex2"), "SELECT * FROM movies", "title");
    }
}
