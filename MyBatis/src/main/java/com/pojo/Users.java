package com.pojo;

/**
 * @author csk
 * @date 2023/11/30 17:28
 */
public class Users {
    private int id;
    private String username;
    private String password;

    public Users(){

    }
    public Users(String username,String password){
        this.username = username;
        this.password = password;
    }
    public Users(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
