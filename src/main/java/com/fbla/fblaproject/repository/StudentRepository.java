/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tharun Saravanan
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
 
    @Query(value = "SELECT * FROM STUDENT WHERE GRADE = ?1 ORDER BY NAME", nativeQuery = true)
    List<Student> getStudents(int grade);
}
