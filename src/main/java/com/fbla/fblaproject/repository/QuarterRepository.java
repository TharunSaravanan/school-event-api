/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Quarter;
import com.fbla.fblaproject.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Tharun Saravanan
 */
public interface QuarterRepository extends JpaRepository<Quarter, String> {
 
    @Query(value = "SELECT * FROM QUARTER WHERE NAME = ?1", nativeQuery = true)
    Quarter getQuarter(String name);
    
}
