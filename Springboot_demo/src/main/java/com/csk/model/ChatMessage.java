package com.csk.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chatmessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "message")
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    protected  ChatMessage(){

    }
    public ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
        this.time = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }
// Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}