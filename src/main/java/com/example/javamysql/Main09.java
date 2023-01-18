package com.example.javamysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main09 {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT * FROM movies JOIN cinemas ORDER BY `movie_id` ASC";
        String memory = "";
        String space = " ";
        StringBuilder sb = new StringBuilder();
        try(PreparedStatement preparedStatement = DbUtil.connect("cinemas_ex2").prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(!memory.equals(resultSet.getString("title"))){
                sb.append(resultSet.getString("title") + space);
                sb.append(resultSet.getString("description") + space);
                sb.append(resultSet.getString("rating") + space);
                System.out.println(sb);
                memory = resultSet.getString("title");
                 
                }
                sb.append(resultSet.getString("name") + space);
            }
        }
    }
}
