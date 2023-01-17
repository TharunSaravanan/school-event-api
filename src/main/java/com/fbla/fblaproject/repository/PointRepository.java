/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.Point;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tharun Saravanan
 */
@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    
    @Query(value = "SELECT * FROM POINT WHERE EVENTID = ?1 AND STUDENTGRADE = ?2 ORDER BY TIME DESC", nativeQuery = true)
    List<Event> getEventPoints(int eventId, int studentGrade);
    
}
