package com.lgj.mysqlTest.Bean;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data   //包含了get、set和toString
//@AllArgsConstructor //有参构造器set
//@NoArgsConstructor  //无参构造器get
public class cityBean {
    private String city;
    private String tempMax;
    private String tempMin;

    public String getCity() {
        return city;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }
}
