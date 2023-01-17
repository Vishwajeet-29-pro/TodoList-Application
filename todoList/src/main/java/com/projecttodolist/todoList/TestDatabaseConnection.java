package com.projecttodolist.todoList;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class TestDatabaseConnection {
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/todo_list_directory?useSSL=false&serverTimezone=UTC";
	        String username = "admin@todo";
	        String password = "todoadmin";

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            System.out.println("Connection to database successful!");

	            try (Statement statement = connection.createStatement();
	                  ResultSet resultSet = statement.executeQuery("SELECT * from to_do_items")) {
	                if (resultSet.next()) {
	                    int result = resultSet.getInt(1);
	                    System.out.println("Result of query: " + result);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error connecting to database: " + e.getMessage());
	        }
	    }
	}



