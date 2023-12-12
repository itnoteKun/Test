package com.csk.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author csk
 * @date 2023/11/21 17:38
 */
@RestController
public class MapController {

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }



}
