package com.quadfour.dto;

public class CategorizedTasksDTO {

    private QuadrantDTO importantUrgent = new QuadrantDTO();
    private QuadrantDTO importantNotUrgent = new QuadrantDTO();
    private QuadrantDTO notImportantUrgent = new QuadrantDTO();
    private QuadrantDTO notImportantNotUrgent = new QuadrantDTO();

    // IMPORTANT AND URGENT

    public QuadrantDTO getImportantUrgent() {
        return importantUrgent;
    }

    public void setImportantUrgent(QuadrantDTO importantUrgent) {
        this.importantUrgent = importantUrgent;
    }

    public void addImportantUrgent(TaskDTO task) {
        this.importantUrgent.addTask(task);
    }



    // IMPORTANT AND NOT URGENT

    public QuadrantDTO getImportantNotUrgent() {
        return importantNotUrgent;
    }

    public void setImportantNotUrgent(QuadrantDTO importantNotUrgent) {
        this.importantNotUrgent = importantNotUrgent;
    }

    public void addImportantNotUrgent(TaskDTO task) {
        this.importantNotUrgent.addTask(task);
    }



    // NOT IMPORTANT AND URGENT

    public QuadrantDTO getNotImportantUrgent() {
        return notImportantUrgent;
    }

    public void setNotImportantUrgent(QuadrantDTO notImportantUrgent) {
        this.notImportantUrgent = notImportantUrgent;
    }

    public void addNotImportantUrgent(TaskDTO task) {
        this.notImportantUrgent.addTask(task);
    }



    // NOT IMPORTANT AND NOT URGENT

    public QuadrantDTO getNotImportantNotUrgent() {
        return notImportantNotUrgent;
    }

    public void setNotImportantNotUrgent(QuadrantDTO notImportantNotUrgent) {
        this.notImportantNotUrgent = notImportantNotUrgent;
    }

    public void addNotImportantNotUrgent(TaskDTO task) {
        this.notImportantNotUrgent.addTask(task);
    }



    @Override
    public String toString() {
        return importantUrgent.toString() + " " + importantNotUrgent.toString() + " " + notImportantUrgent.toString() + " " + notImportantNotUrgent.toString();
    }
}
