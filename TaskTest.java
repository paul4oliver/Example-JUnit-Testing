package test;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Task;

class TaskTest {  

	@Test
	@DisplayName("Test creating task successffuly")
	void testCreateTaskSuccess() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");
		
		assertTrue(task != null, "Create Task Fail");
		assertTrue(task.getTaskId().equals("0000000001"), "Create Task Fail: Id");
		assertTrue(task.getTaskName().equals("Water Plants"), "Create Task Fail: Name");
		assertTrue(task.getTaskDescription().equals("Water the tomoatoes in the garden."), "Create Task Fail: Description");
	}
	
	@Test
	@DisplayName("Test creating task with Id too long")
	void testCreateTaskIdTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("00000000001", "Water Plants", "Water the tomoatoes in the garden.");
		}, "Create Task Fail: Id Too Long");	
	}
	
	@Test
	@DisplayName("Test creating task with null Id")
	void testCreateTaskNullId() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Water Plants", "Water the tomoatoes in the garden.");
		}, "Create Task Fail: Id Null");	
	}
	
	@Test
	@DisplayName("Test creating task with name that is too long")
	void testCreateTaskNameTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000001", "Water Plants They Are Dead!", "Water the tomoatoes in the garden.");
		}, "Create Task Fail: Name Too Long");	
	}
	
	@Test
	@DisplayName("Test creating task with null name")
	void testCreateTaskNullName() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000001", null, "Water the tomoatoes in the garden.");
		}, "Create Task Fail: Name Null");	
	}
	
	@Test
	@DisplayName("Test creating task with description that is too long")
	void testCreateTaskDescriptionTooLong() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden. It is not suppose to rain until next thursday and you don't want them to die.");
		}, "Create Task Fail: Description Too Long");	
	}
	
	@Test
	@DisplayName("Test creating task with null description")
	void testCreateTaskNullDescription() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000001", "Water Plants", null);
		}, "Create Task Fail: Description Null");	
	}
	
	@Test
	@DisplayName("Test updating task successffuly")
	void testUpdateTaskSuccess() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");	

		task.setTaskName("New Name");
		task.setTaskDescription("New Description");

		assertTrue(task.getTaskId().equals("0000000001"), "ID not set.");
		assertTrue(task.getTaskName().equals("New Name"), "Update Task Fail: Name");
		assertTrue(task.getTaskDescription().equals("New Description"), "Update Task Fail: Description");
	}
	
	@Test
	@DisplayName("Test updating task with name that is too long")
	void testUpdateTaskNameTooLong() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");	
		
		assertFalse(task.setTaskName("Water Plants They Are Dead!"), "Update Task Name Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating task with null name")
	void testUpdateTaskNullName() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");	
		
		assertFalse(task.setTaskName(null), "Update Task Name Fail: Null");
	}
		
	@Test
	@DisplayName("Test updating task with description that is too long")
	void testUpdateTaskDescriptionTooLong() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");	
		
		assertFalse(task.setTaskDescription("New Description New Description New Description New Description"), "Update Task Description Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating task with null description")
	void testUpdateTaskNullDescription() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");	
		
		assertFalse(task.setTaskDescription(null), "Update Task Description Fail: Null");
	}
}
