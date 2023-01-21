/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.Point;
import com.fbla.fblaproject.model.Winner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Tharun Saravanan
 */
public interface WinnerRepository extends JpaRepository<Winner,Integer>  {
    
    
    @Query(value = "SELECT * FROM WINNER WHERE QUARTER_NAME = ?1 ORDER BY STUDENT_GRADE", nativeQuery = true)
    List<Winner> getWinners(String quarterName);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM WINNER WHERE QUARTER_NAME = ?1", nativeQuery = true)
    void deletePrevious(String quarterName);
}
