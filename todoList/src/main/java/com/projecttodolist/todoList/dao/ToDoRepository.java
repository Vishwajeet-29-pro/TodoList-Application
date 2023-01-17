package com.projecttodolist.todoList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecttodolist.todoList.entity.ToDoItem;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoItem, Integer> {
	public ToDoItem findBytext(String text);
	public ToDoItem findById(int id);

}
