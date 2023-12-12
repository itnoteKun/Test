package com.lgj.mysqlTest.Bean;

public class standardDevTempBean {
    private String city;
    private Double standard_aveTemp;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStandard_aveTemp(Double standard_aveTemp) {
        this.standard_aveTemp = standard_aveTemp;
    }

    public Double getStandard_aveTemp() {
        return standard_aveTemp;
    }
}
