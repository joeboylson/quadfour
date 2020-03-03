package com.quadfour.dto;

import java.util.List;
import java.util.ArrayList;
import com.quadfour.dto.TaskDTO;

public class CategorizedTasksDTO {

    private ArrayList<TaskDTO> importantUrgent = new ArrayList<TaskDTO>();
    private ArrayList<TaskDTO> importantNotUrgent = new ArrayList<TaskDTO>();
    private ArrayList<TaskDTO> notImportantUrgent = new ArrayList<TaskDTO>();
    private ArrayList<TaskDTO> notImportantNotUrgent = new ArrayList<TaskDTO>();

    // IMPORTANT AND URGENT

    public List<TaskDTO> getImportantUrgent() {
        return importantUrgent;
    }

    public void setImportantUrgent(ArrayList<TaskDTO> importantUrgent) {
        this.importantUrgent = importantUrgent;
    }

    public void addImportantUrgent(TaskDTO task) {
        this.importantUrgent.add(task);
    }



    // IMPORTANT AND NOT URGENT

    public List<TaskDTO> getImportantNotUrgent() {
        return importantNotUrgent;
    }

    public void setImportantNotUrgent(ArrayList<TaskDTO> importantNotUrgent) {
        this.importantNotUrgent = importantNotUrgent;
    }

    public void addImportantNotUrgent(TaskDTO task) {
        this.importantNotUrgent.add(task);
    }



    // NOT IMPORTANT AND URGENT

    public List<TaskDTO> getNotImportantUrgent() {
        return notImportantUrgent;
    }

    public void setNotImportantUrgent(ArrayList<TaskDTO> notImportantUrgent) {
        this.notImportantUrgent = notImportantUrgent;
    }

    public void addNotImportantUrgent(TaskDTO task) {
        this.notImportantUrgent.add(task);
    }



    // NOT IMPORTANT AND NOT URGENT

    public List<TaskDTO> getNotImportantNotUrgent() {
        return notImportantNotUrgent;
    }

    public void setNotImportantNotUrgent(ArrayList<TaskDTO> notImportantNotUrgent) {
        this.notImportantNotUrgent = notImportantNotUrgent;
    }

    public void addNotImportantNotUrgent(TaskDTO task) {
        this.notImportantNotUrgent.add(task);
    }



    @Override
    public String toString() {
        return importantUrgent.toString() + " " + importantNotUrgent.toString() + " " + notImportantUrgent.toString() + " " + notImportantNotUrgent.toString();
    }
}
