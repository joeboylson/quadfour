package com.quadfour.dto;

import java.util.ArrayList;

public class QuadrantDTO {

    private ArrayList<TaskDTO> quadrantTasks = new ArrayList<TaskDTO>();
    private Boolean isHighImportance = false;
    private Boolean isHighUrgency = false;

    public ArrayList<TaskDTO> getQuadrantTasks() {
        return quadrantTasks;
    }

    public void addTask(TaskDTO task) { quadrantTasks.add(task); }

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
        return isHighImportance.toString() + " " + isHighUrgency.toString();
    }
}
