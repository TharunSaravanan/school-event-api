/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.controller;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.repository.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
@RequestMapping("/event")
@CrossOrigin
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    
    
    @PostMapping("/add")
    public String add(@RequestBody Event event){
        eventRepository.save(event);
        System.out.println("New event added.");
        return "New event added";
                
    }
    
    @GetMapping("/upcomingEvents")
    public List<Event> upcomingEvents(){
        List<Event> result = eventRepository.getUpcomingEvents();
        return result;
    }
    
        
    @GetMapping("/completedEvents")
    public List<Event> getCompletedEvents(){
        List<Event> result = eventRepository.getCompletedEvents();
        return result;
    }
}
