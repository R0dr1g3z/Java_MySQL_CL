package com.example.javamysql;

import java.sql.SQLException;
import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give id");
        int id = scan.nextInt();
        DbUtil.remove(DbUtil.connect("cinemas_ex2"), "movies", id);
    }
}
