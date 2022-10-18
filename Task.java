package model;

//  PAUL KENAGA
//  CS 320 PROJECT ONE
//  10/08/2022

public class Task {
	
	// Local variables
	private String taskId;
	private String taskName;
	private String taskDescription;
	
	// Constructor
	public Task(String taskId, String taskName, String taskDescription)
	{
		boolean isValid = validateInput(taskId, 10);
		
		
		if(isValid)
		{
			this.taskId = taskId;
		}
		
		isValid = isValid && setTaskName(taskName);
		isValid = isValid && setTaskDescription(taskDescription);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}

	// Mutators
	public boolean setTaskName(String taskName) 
	{
		boolean isValid = validateInput(taskName, 20);
		
		if(isValid)
		{
			this.taskName = taskName;
		}
		
		return isValid;
	}
	
	public boolean setTaskDescription(String taskDescription) 
	{
		boolean isValid = validateInput(taskDescription, 50);
		
		if(isValid)
		{
			this.taskDescription = taskDescription;
		}
		
		return isValid;
	}
	
	// Accessors
	public String getTaskId()
	{
		return taskId;
	}
			
	public String getTaskName()
	{
		return taskName;
	}
			
	public String getTaskDescription()
	{
		return taskDescription;
	}
		
	// Method to validate input is not null and meets length requirements
	private boolean validateInput(String item, int length)
	{
		return(item != null && item.length() <= length);
	}
}