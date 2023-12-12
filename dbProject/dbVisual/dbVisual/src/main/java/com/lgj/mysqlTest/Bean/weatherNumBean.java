package com.lgj.mysqlTest.Bean;

public class weatherNumBean {
    private String city;
    private String province;
    private String weather;
    private Integer weatherNum;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Integer getWeatherNum() {
        return weatherNum;
    }

    public void setWeatherNum(Integer weatherNum) {
        this.weatherNum = weatherNum;
    }
}
