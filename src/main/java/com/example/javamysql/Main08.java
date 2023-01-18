package com.example.javamysql;

public class Main08 {

    public String query1 = "UPDATE offers SET price = price+1000 WHERE id BETWEEN 20 AND 25;";

    public String query2 = "DELETE * FROM offers WHERE DATE(expire) <= DATE_SUB(NOW(), INTERVAL 3 DAY);";

    public String query3 = "SELECT * FROM offers WHERE phone LIKE '+48%' AND promoted = 1 AND DATE(expire) > NOW();";

    public String query4 = "UPDATE offers SET status = 1 WHERE SUBSTRING(phone,3,2) = '48';";
}
