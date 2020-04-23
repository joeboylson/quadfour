package com.quadfour.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
public class UserDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Integer userId;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;

    @OneToMany(mappedBy = "userId")
    private List<TaskDTO> userTasks;

    public int getId() {
        return userId;
    }

    public void setId(Integer id) { this.userId = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskDTO> getUserTasks() { return this.userTasks; }

    public void setUserTasks(List<TaskDTO> tasks) {
        this.userTasks = tasks;
    }
}
