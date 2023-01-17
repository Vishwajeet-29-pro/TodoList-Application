package com.projecttodolist.todoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttodolist.todoList.dao.ToDoRepository;
import com.projecttodolist.todoList.entity.ToDoItem;


@Service
public class ToDoService {

	
	private final ToDoRepository toDoRepository;

	@Autowired
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository=toDoRepository;
	}
	
	public ToDoItem getById(int id) {
		ToDoItem result = toDoRepository.findById(id);
		if(result ==null) {
			throw new RuntimeException("Id not found "+id);
		}
		return result;
	}
	
	public List<ToDoItem> getAll() {
		return toDoRepository.findAll();
	}
	
	public void saveToDoItem(ToDoItem todoItem) {
		todoItem.toString();
		toDoRepository.save(todoItem);
	}
	
	public ToDoItem updateToDoItem(int itemId,ToDoItem toDoItem) {
		ToDoItem item = toDoRepository.findById(itemId);
		if(item==null) {
			throw new RuntimeException("Id not found "+itemId);
		}
		item.setText(toDoItem.getText());
		item.setIsComplete(toDoItem.getIsComplete());
		item.setCreatedAt(toDoItem.getCreatedAt());
		item.toString();
		
		return toDoRepository.save(item);		
	}

	public void deleteById(int id) {
		ToDoItem itemid = toDoRepository.findById(id);
		toDoRepository.delete(itemid);
		
	}

}
