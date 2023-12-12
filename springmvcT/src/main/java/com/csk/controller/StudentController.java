package com.csk.controller;

import com.csk.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("student","command",new Student());
    }

    @RequestMapping(value = "/student/add",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("Student")Student student, Model model){
        model.addAttribute("id",student.getId());
        model.addAttribute("name",student.getName());
        model.addAttribute("sex",student.getSex());
        model.addAttribute("age",student.getAge());
        model.addAttribute("classes",student.getClasses());

        return "result";
    }
}
