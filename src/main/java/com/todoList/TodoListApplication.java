package com.todoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TodoListApplication {

	public static void main(String[] args) {

		SpringApplication.run(TodoListApplication.class, args);
	}

}
