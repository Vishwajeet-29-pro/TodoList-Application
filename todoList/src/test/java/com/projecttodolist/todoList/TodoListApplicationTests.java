package com.projecttodolist.todoList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;




@SpringBootTest
class TodoListApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
	}
	
	@Disabled
	@Test
	public void testDatabaseConnection() {
	    // Get the data source from the application context
	    DataSource dataSource = applicationContext.getBean(DataSource.class);

	    // Verify that the data source is configured correctly
	    assertThat(dataSource).isNotNull();
	    assertThat(dataSource.getClass().getName()).isEqualTo("com.mysql.cj.jdbc.MysqlDataSource");

	    // Test the connection to the database
	    try (Connection connection = dataSource.getConnection()) {
	        assertThat(connection).isNotNull();

	        // Test a simple query
	        try (Statement statement = connection.createStatement();
	              ResultSet resultSet = statement.executeQuery("SELECT 1 + 1")) {
	            assertThat(resultSet).isNotNull();
	            assertThat(resultSet.next()).isTrue();
	            assertThat(resultSet.getInt(1)).isEqualTo(2);
	        }
	    } catch (SQLException e) {
	        fail("Error testing database connection", e);
	    }
	}


}
