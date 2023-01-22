/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.LeaderBoardPoint;
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
    
    @Query(value = "SELECT * FROM POINT WHERE event_id = ?1 and STUDENT_GRADE = ?2", nativeQuery = true)
    List<Point> getEventPoints(int eventId, int grade);
    
    @Query(value = "SELECT student_id as StudentId, s.name as StudentName, \n" +
                    "student_grade as StudentGrade, sum(points) as TotalPoints\n" +
                    "FROM point p, student s, event e\n" +
                    "WHERE p.student_id = s.id\n" +
                    "AND p.event_id = e.id\n" +
                    "AND e.time >= (select start_date from quarter where name = ?1)\n" +
                    "group by student_id, student_grade, points\n" +
                    "order by StudentGrade, TotalPoints desc", nativeQuery = true)
    List<LeaderBoardPoint> getLeaderBoardForQuarter(String quarterName);
}
