package com.fitnesstrackerapp.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FitnessAppController {
    /**
     * Handle the root (/) endpoint and return a start page @return (currently no start page)
     *
     */
    @RequestMapping("/")
    public String index(){
     return ("start");
    }
}
