/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.controller;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.LeaderBoardPoint;
import com.fbla.fblaproject.model.Point;
import com.fbla.fblaproject.model.Student;
import com.fbla.fblaproject.repository.EventRepository;
import com.fbla.fblaproject.repository.PointRepository;
import com.fbla.fblaproject.repository.StudentRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @Autowired
    private StudentRepository studentRepository;
    
    @PostMapping("/addPoints")
    public void add(@RequestBody Point[] points) {
        pointRepository.saveAll(Arrays.asList(points));

    }
    
    @PostMapping("/add")
    public void add(@RequestBody Point point) {
        pointRepository.save(point);
    }
    
    @GetMapping("/pointsForEvent")
    public List<Point> getStudentsInGrade(int eventId, int grade) {
        List<Point> result = pointRepository.getEventPoints(eventId, grade);
        return result;
    }
    
    @GetMapping("/leaderBoard")
    public List<LeaderBoardPoint> getLeaderBoard() {
        return pointRepository.getLeaderBoard();
    }
}
