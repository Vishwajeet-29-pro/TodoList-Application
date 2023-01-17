package com.projecttodolist.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projecttodolist.todoList.entity.ToDoItem;
import com.projecttodolist.todoList.service.ToDoService;

@Controller
@RequestMapping("/list")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	public ToDoController(ToDoService service) {
		toDoService=service;
	}
	
	// Get all the elements of list
	
	@GetMapping("/getall")
	public String allItems(Model model) {
		List<ToDoItem> item = toDoService.getAll();
		model.addAttribute("item",item);
		return "list-items";
	}
	
	// Open form for adding new list item
	
	@GetMapping("/showFormForAdd")
	public String addItem(Model model) {
		ToDoItem item = new ToDoItem();
		model.addAttribute("item", item);
		return "add-new";
	}
	
	// On submit form data post in database
	
	@PostMapping("/item")
	public String addItem(@ModelAttribute("item") ToDoItem item) {	
		toDoService.saveToDoItem(item);
		return "redirect:/list/getall";
	}
	
	// Update the existing list (update status and complete date)
	
	@GetMapping("/todo-update-form")
	public String updateTodo(@RequestParam("id") int id, Model model) {
		ToDoItem item = toDoService.getById(id);
		model.addAttribute("item", item);
		toDoService.saveToDoItem(item);
		
		return "add-new";
	}
	
	// Delete the list item 
	
	@GetMapping("/todo/{id}")
	public String deleteById(@PathVariable int id) {
		toDoService.deleteById(id);
		return "redirect:/list/getall";
	}
}
