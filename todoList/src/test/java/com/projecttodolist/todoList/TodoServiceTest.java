package com.projecttodolist.todoList;

	
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.junit.jupiter.MockitoExtension;


import com.projecttodolist.todoList.dao.ToDoRepository;
import com.projecttodolist.todoList.entity.ToDoItem;
import com.projecttodolist.todoList.service.ToDoService;

	@ExtendWith(MockitoExtension.class)
	@RunWith(MockitoJUnitRunner.class)
	public class TodoServiceTest {

	    @Mock
	    private ToDoRepository todoRepository;

	    @InjectMocks
	    private ToDoService todoService;
	    
	    ToDoItem item1 = new ToDoItem(1, "Test Item 1", true, LocalDate.now());
        ToDoItem item2 = new ToDoItem(2, "Test Item 2", false, LocalDate.now());
       
        List<ToDoItem> mockTodoItems = Arrays.asList(item1, item2);
        
	    @Test
	    public void testGetAllTodos() {
	    	
	       
	        when(todoRepository.findAll()).thenReturn(mockTodoItems);

	        List<ToDoItem> todoItems = todoService.getAll();

	        assertEquals(2, todoItems.size());
	        assertEquals(1, todoItems.get(0).getId());
	        assertEquals("Test Item 1", todoItems.get(0).getText());
	        assertEquals(true, todoItems.get(0).getIsComplete());
	        assertEquals(LocalDate.now(), todoItems.get(0).getCreatedAt());
	    }
	    
	    @Test
	    public void saveItems() {
	    	ToDoItem item = new ToDoItem();
	    	item.setId(0);
	    	item.setText("this is test item");
	    	item.setIsComplete(false);
	    	item.setCreatedAt(LocalDate.now());
	    	
	    	todoRepository = mock(ToDoRepository.class);
	    	todoService = new ToDoService(todoRepository);
	    	todoService.saveToDoItem(item);
	    	
	    	verify(todoRepository).save(item);
	    }
	    
	    @Test
	    public void updateItems() {
	    	ToDoItem mockitem = mock(ToDoItem.class);
	    	when(mockitem.getId()).thenReturn(1);
	    	when(mockitem.getText()).thenReturn("Update todo list");
	    	when(mockitem.getIsComplete()).thenReturn(false);
	    	when(mockitem.getCreatedAt()).thenReturn(LocalDate.now());
	    	
	    	todoService.updateItem(mockitem);
	    	
	    	assertEquals(1, mockitem.getId());
	    	
	    }
	    
	    @Test
	    public void deleteItem() {
	       
	        ToDoItem item = new ToDoItem(123, "Delete me", false, LocalDate.now());

	        todoService.saveToDoItem(item);
	        todoService.deleteById(item.getId());
	        assertFalse(todoRepository.findById(123)!=null);
	    }

	}
	


