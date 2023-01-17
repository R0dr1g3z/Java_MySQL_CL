package com.example.javamysql;

import java.sql.SQLException;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give cinema name");
        String name = scan.nextLine();
        System.out.println("Give cinema adress");
        String adress = scan.nextLine();
        addCinema(name, adress);
    }

    static void addCinema(String name, String adress) throws SQLException {
        DbUtil.insert(DbUtil.connect("cinemas_ex2"), "INSERT INTO cinemas VALUES(NULL,?,?)", name, adress);
    }
}
