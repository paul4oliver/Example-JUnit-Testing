package services;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import java.util.HashMap;
import java.util.Map;
import model.Task; 

public class TaskService {
	
	// Local variables
	private static TaskService reference = new TaskService();
	private final Map<String, Task> tasks;
		
	// HashMap to store key value pair with unique ID and tasks 
	public TaskService()
	{
		this.tasks = new HashMap<String, Task>();
	}
	
	// Method to create instance of Singleton TaskService
	public static TaskService getService()
	{
		return reference;
	}
		
	// Method to add a task with a unique Id
	public boolean addTask(Task task)
	{
		boolean isSuccess = false;
			
		if(!tasks.containsKey(task.getTaskId()))
		{
			tasks.put(task.getTaskId(), task);
			isSuccess = true;
		}
			
		return isSuccess;
	}
		
	// Method to delete a task per task Id
	public boolean deleteTask(String taskId)
	{		
		return tasks.remove(taskId) != null;
	}
		
	// Method to update a task name per task Id
	public boolean updateTaskName(String taskId, String updatedTaskName)
	{		
		boolean isSuccess = false;
		if(tasks.containsKey(taskId))
		{
			getTask(taskId).setTaskName(updatedTaskName);
			if(getTask(taskId).getTaskName() ==  updatedTaskName)
			{
				isSuccess = true;
			}
		}
			
		return isSuccess;
	}
		
	// Method to update a task description per task Id
	public boolean updateTaskDescription(String taskId, String updatedTaskDescription)
	{		
		boolean isSuccess = false;
		if(tasks.containsKey(taskId))
		{
			getTask(taskId).setTaskDescription(updatedTaskDescription);
			if(getTask(taskId).getTaskDescription() ==  updatedTaskDescription)
			{
				isSuccess = true;
			}
		}
					
		return isSuccess;
	}
		
	// Method to retrieve Task object
	public Task getTask(String taskId)
	{
		return tasks.get(taskId);
	} 
}