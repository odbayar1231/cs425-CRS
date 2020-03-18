package edu.miu.cs425.project.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {


    @GetMapping(value = "/classes")
    public String displayAvailableClasses(){
        return "/registration/index";
    }

}
