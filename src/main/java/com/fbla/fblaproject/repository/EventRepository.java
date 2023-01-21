/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;
import com.fbla.fblaproject.model.Event;
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
public interface EventRepository extends JpaRepository<Event,Integer> {
    
    @Query(value = "SELECT * FROM EVENT WHERE TIME < CURDATE() ORDER BY TIME DESC", nativeQuery = true)
    List<Event> getCompletedEvents();
    
    @Query(value = "SELECT * FROM EVENT WHERE TIME >= CURDATE() ORDER BY TIME DESC", nativeQuery = true)
    List<Event> getUpcomingEvents();
    

    
}
