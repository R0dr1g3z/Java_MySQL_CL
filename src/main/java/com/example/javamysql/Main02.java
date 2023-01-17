package com.example.javamysql;

import java.sql.SQLException;

public class Main02 {
    public static void main(String[] args) throws SQLException {
        String name = "Natalia";
        String surname = "Malinowska";
        DbUtil.insert(DbUtil.connect("products_ex2"), "INSERT INTO clients VALUES(NULL,?,?)", name, surname);
    }
}