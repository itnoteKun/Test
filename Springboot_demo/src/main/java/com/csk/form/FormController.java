package com.csk.form;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author csk
 * @date 2023/11/21 22:07
 */

@RestController
public class FormController {

        @RequestMapping("/form")
        public ModelAndView H_form(){
            return new ModelAndView("form");
        }
        @GetMapping("/form1")
            public String setForm(@RequestParam("username") String us,
                                  @RequestParam("password") String ps,
                                  @RequestParam( value = "hobby",required = false ) List<String> hobby
                                ){
                return "username:"+us+"\tpassword:"+ps+"\thobby:"+hobby;
            }

}
