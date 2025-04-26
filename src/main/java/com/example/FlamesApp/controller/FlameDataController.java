package com.example.FlamesApp.controller;

import com.example.FlamesApp.model.FlameEntity;
import com.example.FlamesApp.service.FlameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlameDataController {
    @Autowired
    private FlameDataService service;
    @PostMapping("/")
    public String fun(@RequestBody FlameEntity f){
        String c;

        c=service.flames(f.getA(),f.getB());
        return c;


    }
}
