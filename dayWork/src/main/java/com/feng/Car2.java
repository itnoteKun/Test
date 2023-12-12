package com.feng;

public class Car2 {
    private String type;
    private String id;

    public Car2(String type, String id){
        this.type=type;
        this.id=id;
    }

    public String getType(){
        return type;
    }
    public String getId(){
        return  id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }
}
