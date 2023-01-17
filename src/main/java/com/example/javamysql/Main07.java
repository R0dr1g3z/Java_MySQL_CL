package com.example.javamysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        start();
        while (scan.hasNextLine()) {
            switch (scan.next()) {
                case "add":
                Scanner scanAdd = new Scanner(System.in);
                System.out.println("Select name");
                String name = scanAdd.nextLine();
                System.out.println("Select adress");
                String adress = scanAdd.nextLine();
                String query = "INSERT INTO cinemas (id,name,address) VALUES (NULL,?,?);";
                DbUtil.insert(DbUtil.connect("cinemas_ex2"), query, name, adress);
                start();
                break;

                case "edit":
                    editData();
                    break;

                case "delete":
                    Scanner scanDelete = new Scanner(System.in);
                    System.out.println("Select id to delete");
                    int id = scanDelete.nextInt();
                    System.out.println("Are you sure you want delete this cinema?\nY: N:");
                    String check = scan.next();
                    if (check.toLowerCase().equals("y")) {
                        DbUtil.remove(DbUtil.connect("cinemas_ex2"), "cinemas", id);
                        start();
                    }
                    start();
                    break;

                case "exit":
                    System.out.println("Program closed");
                    System.exit(0);

                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }

    private static void editData() throws SQLException {
        Scanner scanEdit = new Scanner(System.in);
        System.out.println("Select Id to edit");
        String id = scanEdit.nextLine();
        System.out.println("Select new name");
        String name = scanEdit.nextLine();
        System.out.println("Select new adress");
        String adress = scanEdit.nextLine();
        String query = "UPDATE cinemas SET name = ?, address = ? WHERE id = ?;";
        DbUtil.insert(DbUtil.connect("cinemas_ex2"), query, name, adress, id);
        start();
    }

    private static void start() throws SQLException {
        try (Connection connection = DbUtil.connect("cinemas_ex2")) {
            String sql = "SELECT * FROM cinemas";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Id: " + resultSet.getString(1) + " ");
                sb.append("Name: " + resultSet.getString(2) + " ");
                sb.append("Adress: " + resultSet.getString(3) + " ");
                System.out.println(sb);
            }
        }
        System.out.println("Select one:\nadd\nedit\ndelete\nexit");
    }
}
