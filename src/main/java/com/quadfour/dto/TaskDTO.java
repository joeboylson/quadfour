package com.quadfour.dto;

import javax.persistence.*;

@Entity
@Table(name="TASKS")
public class TaskDTO {
	
	/*
	 * - add in attr's (taskId, taskText, etc...)
	 * - select all > right click > source > generate getter and setters
	 * - in GUI > select all > set "insert point" to after "isHighUrgency" (or last attr.) 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TASK_ID")
	private int taskId;
	@Column(name="TASK_TEXT")
	private String taskText;
	@Column(name="IS_HIGH_IMPORTANCE")
	private Boolean isHighImportance;
	@Column(name="IS_HIGH_URGENCY")
	private Boolean isHighUrgency;
	@Column(name="userId")
	private int userId;
	
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return taskId + " " + taskText + " " + isHighImportance + " " + isHighUrgency + " "; 
	}
}
