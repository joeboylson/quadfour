package com.quadfour.dto;

import javax.persistence.*;

@Entity
public class TaskDTO {
	
	/*
	 * - add in attr's (taskId, taskText, etc...)
	 * - select all > right click > source > generate getter and setters
	 * - in GUI > select all > set "insert point" to after "isHighUrgency" (or last attr.) 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	private String taskText;
	private Boolean isHighImportance;
	private Boolean isHighUrgency;
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskText() {
		return taskText;
	}
	
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	
	public Boolean getIsHighImportance() {
		return isHighImportance;
	}
	
	public void setIsHighImportance(Boolean isHighImportance) {
		this.isHighImportance = isHighImportance;
	}
	
	public Boolean getIsHighUrgency() {
		return isHighUrgency;
	}
	
	public void setIsHighUrgency(Boolean isHighUrgency) {
		this.isHighUrgency = isHighUrgency;
	}
	
	@Override
	public String toString() {
		return taskId + " " + taskText + " " + isHighImportance + " " + isHighUrgency + " "; 
	}
}
