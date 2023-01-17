/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.controller;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.Point;
import com.fbla.fblaproject.repository.EventRepository;
import com.fbla.fblaproject.repository.PointRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tharun Saravanan
 */
@RestController
@RequestMapping("/point")
@CrossOrigin
public class PointController {
    @Autowired
    private PointRepository pointRepository;
    
    @PostMapping("/addPoints")
    public void add(@RequestBody Point[] points) {
        pointRepository.saveAll(Arrays.asList(points));

    }
}
