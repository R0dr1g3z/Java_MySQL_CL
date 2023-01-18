package com.example.javamysql;

import java.sql.SQLException;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick a movie:");
        String movie = scan.nextLine();
        String query = String.format("SELECT * FROM movies WHERE title LIKE '%s%%'", movie);
        DbUtil.printData(DbUtil.connect("cinemas_ex2"), query, "title", "description", "rating");
    }
}
