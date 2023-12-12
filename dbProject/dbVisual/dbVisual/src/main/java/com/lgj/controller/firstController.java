package com.lgj.controller;

import com.lgj.mysqlTest.Bean.standardDevTempBean;
import com.lgj.mysqlTest.DAO.standardDevTempImpl;
import com.lgj.mysqlTest.Bean.weatherNumBean;
import com.lgj.mysqlTest.DAO.weatherNumImpl;
import com.lgj.mysqlTest.Bean.tempTopBean;
import com.lgj.mysqlTest.DAO.tempTopImpl;
import com.lgj.mysqlTest.Bean.monthBean;
import com.lgj.mysqlTest.DAO.monthDataImpl;
import com.lgj.mysqlTest.Bean.tempBean;
import com.lgj.mysqlTest.DAO.tempDaoImpl;
import com.lgj.mysqlTest.Bean.cityBean;
import com.lgj.mysqlTest.DAO.cityDaoImpl;
import com.lgj.mysqlTest.Bean.windDirBean;
import com.lgj.mysqlTest.DAO.windDirImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@ResponseBody
//@Controller

@RestController
public class firstController {
    @Autowired
    private cityDaoImpl cityDaoImpl;

    @Autowired
    private tempDaoImpl tempDaoImpl;

    @Autowired
    private windDirImpl windDirImpl;

    @Autowired
    private monthDataImpl monthDataImpl;

    @Autowired
    private tempTopImpl tempTopImpl;

    @Autowired
    private weatherNumImpl weatherNumImpl;

    @Autowired
    private standardDevTempImpl standardDevTempImpl;

    @RequestMapping("/staDevTemp")
    public ModelAndView staDevTemp(){
        return new ModelAndView("deltaTemp");
    }

    @RequestMapping("/staDevTempData")
    public List staDevTempData(){
        List<standardDevTempBean> list = standardDevTempImpl.findAll();
        return list;
    }

    @RequestMapping("/weatherNum")
    public ModelAndView weatherNum(){
        return new ModelAndView("weatherNum");
    }

    @RequestMapping("/weatherNumData")
    public List weatherNumData(@RequestParam("city") String city){
        List<weatherNumBean> list = weatherNumImpl.findByCity(city);
        return list;
    }

    @RequestMapping("/tempTop")
    public ModelAndView tempTop(){
        return new ModelAndView("tempTop");
    }

    @RequestMapping("/tempTopData")
    public List findTempTop(){
        List<tempTopBean> list = tempTopImpl.findTop();
        return list;
    }

    @RequestMapping("/monthDataGet")
    public List findMonthData(@RequestParam("province") String province) {
        List<monthBean> list = monthDataImpl.findMonthData(province);
        return list;
    }

    @RequestMapping("/monthData")
    public ModelAndView monthData() {
        return new ModelAndView("monthData");
    }

    @RequestMapping("/lineChart")
    public ModelAndView lineChart() {
        return new ModelAndView("lineChart");
    }

    @RequestMapping("/lineChartData")
    public List findData(@RequestParam("province") String province) {
        List<windDirBean> list = windDirImpl.findData(province);
        return list;
    }

    @RequestMapping("/dbVisual")
    public ModelAndView dbVisual() {
        return new ModelAndView("dbVisual");
    }

    @RequestMapping("/chinaData")
    public List findtempAll() {
        List<tempBean> list = tempDaoImpl.findall();
        return list;
    }

    @RequestMapping("/china")
    public ModelAndView chinaView() {
        return new ModelAndView("china");
    }

    @RequestMapping("/cityWeatherMaxAndMinData")
    public List findAll() {
        List<cityBean> list = cityDaoImpl.findall();
        String str = "";
        for (cityBean cityBean : list) {
            str += (cityBean.getCity() + " " + cityBean.getTempMax() + " " + cityBean.getTempMin());
        }
        return list;
    }

    @RequestMapping("/cityWeatherMaxAndMin")
    public ModelAndView cityWeatherMaxAndMin() {
        return new ModelAndView("cityWeatherMaxAndMin");
    }

    @RequestMapping("/echarts")
    public ModelAndView echarts() {
        return new ModelAndView("echart");
    }
}
