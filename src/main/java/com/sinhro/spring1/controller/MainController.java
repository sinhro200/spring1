package com.sinhro.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView  index() {
        Map<String, Object> params = new HashMap<>();
        params.put("PORT", System.getenv("PORT"));
        params.put("sas","zaz");

        //return "index.html";
        return new ModelAndView("index", params);
    }
}