/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.controller;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.Student;
import com.fbla.fblaproject.repository.EventRepository;
import com.fbla.fblaproject.repository.StudentRepository;
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
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentRepository.save(student);
        return "New student is added";
        
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        List<Student> result = studentRepository.findAll();
        return result;
    }
    
    @GetMapping("/studentsInGrade")
    public List<Student> getStudentsInGrade(int grade) {
        List<Student> result = studentRepository.getStudents(grade);
        return result;
    }
}
