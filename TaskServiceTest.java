package test;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

// Reference for JUnit Test Case: https://www.javatpoint.com/junit-test-case-example-in-java	
// Reference for assertAll: https://www.javaguides.net/2018/09/junit-5-assertall-example.html

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import model.Task;
import services.TaskService;

 

class TaskServiceTest {
	
private static TaskService taskService;
	
	@BeforeAll
	static void setup(){
		taskService = TaskService.getService();
	}
	
	@Test
	@DisplayName("Test adding task successffuly")
	void testAddTaskSuccess() {
		
		Task task = new Task("0000000001", "Water Plants", "Water the tomoatoes in the garden.");
		
		assertTrue(taskService.addTask(task), "Add Task Fail");
		assertTrue("0000000001".contentEquals(task.getTaskId()), "Add Task Fail: Id");
		assertTrue("Water Plants".contentEquals(task.getTaskName()), "Add Task Fail: Name");
		assertTrue("Water the tomoatoes in the garden.".contentEquals(task.getTaskDescription()), "Add Task Fail: Description");
	}
	
	@Test
	@DisplayName("Test adding multiple tasks successffuly")
	void testAddMultipleTasksSuccess() {
		
		Task task1 = new Task("0000000002", "Water Plants", "Water the tomoatoes in the garden.");
		Task task2 = new Task("0000000003", "Take Out Trash", "Seperate recycables to protect Mother Earth.");
		
		assertTrue(taskService.addTask(task1), "Add Multiple Tasks Fail: task1");		
		assertTrue(taskService.addTask(task2), "Add Multiple Tasks Fail: task2");
	}
	
	@Test
	@DisplayName("Test adding duplicate task Ids")
	void testAddDuplicateIdFail() {
		
		Task task1 = new Task("0000000004", "Water Plants", "Water the tomoatoes in the garden.");
		Task task2 = new Task("0000000004", "Take Out Trash", "Seperate recycables to protect Mother Earth.");
		
		assertTrue(taskService.addTask(task1), "Add Duplicate Task IDs Fail: task1");		
		assertFalse(taskService.addTask(task2), "Add Duplicate Task IDs Fail: task2");
	}
		
	@Test
	@DisplayName("Test deleting a task successfully")
	void testGetTaskAndDeleteSuccess() {
		
		Task task1 = new Task("0000000005", "Water Plants", "Water the tomoatoes in the garden.");
		
		assertTrue(taskService.addTask(task1), "Delete Task Fail: Add Task");	
		assertTrue(taskService.deleteTask(task1.getTaskId()), "Delete Task Fail: Delete Task");
		assertTrue(taskService.getTask(task1.getTaskId()) == null, "Delete Task Fail: Get Task");
	}

	@Test 
	@DisplayName("Test deleting a task with nonexistant Id")
	void testDeleteInvalidTaskFail() {
		
		String invalidTaskId = "1";
		
		assertFalse(taskService.deleteTask(invalidTaskId), "Delete Nonexistant Task ID Fail");
	}
	
	@Test
	@DisplayName("Test getting and updating a task name successfully")
	void testGetTaskAndUpdateNameSuccess() {
		
		Task task = new Task("0000000006", "Water Plants", "Water the tomoatoes in the garden.");

		taskService.addTask(task);
		taskService.updateTaskName(task.getTaskId(), "Updated Task Name");
		
		assertTrue(task.getTaskName().equals("Updated Task Name"), "Update Task Name Fail: 0 < String Length < 20");	
	}
	
	@Test
	@DisplayName("Test getting and updating task name to empty string successfully")
	void testGetTaskAndUpdateEmptyNameSuccess() {
		
		Task task = new Task("0000000007", "Water Plants", "Water the tomoatoes in the garden.");

		taskService.addTask(task);
		taskService.updateTaskName(task.getTaskId(), "");
		
		assertTrue(task.getTaskName().equals(""), "Update Task Name Fail: String Length = 0");	
	}
	
	@Test
	@DisplayName("Test getting and updating a task name that is too long")
	void testGetTaskAndUpdateNameTooLong() {
		
		Task task = new Task("0000000008", "Water Plants", "Water the tomoatoes in the garden.");

		assertTrue(taskService.addTask(task), "Failed to add task");		
		assertFalse(taskService.updateTaskName(task.getTaskId(), "Updated Task Name Too Long"), "Update Task Name Fail: String Length > 20");			
	}
	
	@Test
	@DisplayName("Test getting and updating a task name with null")
	void testGetTaskAndUpdateNameNull() {
		
		Task task = new Task("0000000009", "Water Plants", "Water the tomoatoes in the garden.");
	
		assertTrue(taskService.addTask(task), "Failed to add task");	
		assertFalse(taskService.updateTaskName(task.getTaskId(), null), "Update Task Name Fail: Null");
	}
	
	@Test
	@DisplayName("Test getting and updating a task description successfully")
	void testGetTaskAndUpdateDescriptionSuccess() {
		
		Task task = new Task("0000000010", "Water Plants", "Water the tomoatoes in the garden.");
		
		taskService.addTask(task);
		taskService.updateTaskDescription(task.getTaskId(), "Updated Task Description");	

		assertTrue(task.getTaskDescription().equals("Updated Task Description"), "Update Task Description Fail:  0 < String Length < 50");
	}
	
	@Test
	@DisplayName("Test getting and updating an empty task description successfully")
	void testGetTaskAndUpdateEmptyDescriptionSuccess() {
		
		Task task = new Task("0000000011", "Water Plants", "Water the tomoatoes in the garden.");
		
		taskService.addTask(task);
		taskService.updateTaskDescription(task.getTaskId(), "");
	
		assertTrue(task.getTaskDescription().equals(""), "Update Task Name Fail: String Length = 0");	
	}
	
	@Test
	@DisplayName("Test getting and updating a task description that is too long")
	void testGetTaskAndUpdateDescriptionTooLong() {
		
		Task task = new Task("0000000012", "Water Plants", "Water the tomoatoes in the garden.");

		assertTrue(taskService.addTask(task), "Failed to add task");		
		assertFalse(taskService.updateTaskDescription(task.getTaskId(), "Updated Description That Is Too Long. Cannot exceed 50 characters."), "Update Task Decription Fail: String Length > 50");		
	}
	
	@Test
	@DisplayName("Test getting and updating a task description with null")
	void testGetTaskAndUpdateDescriptionNull() {
		
		Task task = new Task("0000000013", "Water Plants", "Water the tomoatoes in the garden.");

		assertTrue(taskService.addTask(task), "Failed to add task");		
		assertFalse(taskService.updateTaskDescription(task.getTaskId(), null), "Update Task Decription Fail: Too Long");		
	}
}
