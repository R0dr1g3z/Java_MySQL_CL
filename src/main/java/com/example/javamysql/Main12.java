package com.example.javamysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        String query = "SELECT * FROM cinemas ";
        try(PreparedStatement preparedStatement = DbUtil.connect("cinemas_ex2").prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Id: " + resultSet.getInt("cinema_id") + " Name: " + resultSet.getString("name"));
            }
        }
        System.out.println("Pick cinema id:");
        int id = scan.nextInt();
        String query2 = "SELECT * FROM cinemas JOIN movies WHERE cinema_id = ?";
        try(PreparedStatement preparedStatement = DbUtil.connect("cinemas_ex2").prepareStatement(query2)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("title"));
            }
        }
    }
}
