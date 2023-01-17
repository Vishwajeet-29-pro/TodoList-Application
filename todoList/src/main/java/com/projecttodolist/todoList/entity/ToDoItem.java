package com.projecttodolist.todoList.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "to_do_items")
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="text",nullable = false)
    private String text;

    @Column(name="is_complete")
    private boolean isComplete;

    @Column(name="createdAt",nullable = false)
    private LocalDate createdAt;

    public ToDoItem() {
    	
    }
    public ToDoItem(String text, boolean isComplete, LocalDate createdAt) {
		this.text = text;
		this.isComplete = isComplete;
		this.createdAt = createdAt;
	}
    
    public ToDoItem(int id,String text, boolean isComplete, LocalDate createdAt) {
		this.id=id;
    	this.text = text;
		this.isComplete = isComplete;
		this.createdAt = createdAt;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ToDoItem [id=" + id + ", text=" + text + ", isComplete=" + isComplete + ", createdAt=" + createdAt
				+ "]";
	}

	

	
    
}
