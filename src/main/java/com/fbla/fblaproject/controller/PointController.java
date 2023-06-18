/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.controller;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.LeaderBoardPoint;
import com.fbla.fblaproject.model.Point;
import com.fbla.fblaproject.model.Quarter;
import com.fbla.fblaproject.model.Student;
import com.fbla.fblaproject.model.Winner;
import com.fbla.fblaproject.repository.EventRepository;
import com.fbla.fblaproject.repository.PointRepository;
import com.fbla.fblaproject.repository.QuarterRepository;
import com.fbla.fblaproject.repository.StudentRepository;
import com.fbla.fblaproject.repository.WinnerRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
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
    
    @Autowired
    private QuarterRepository quarterRepository;
    
    @Autowired
    private WinnerRepository winnerRepository;
    
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
    public List<LeaderBoardPoint> getLeaderBoard(String quarterName) {
        return pointRepository.getLeaderBoardForQuarter(quarterName);
    }
    
    @GetMapping("/quarters")
    public List<Quarter> getQuarters() {
        return quarterRepository.findAll();
    }
    
    @GetMapping("/winner")
    public List<Winner> getWinners(String quarterName) {
        return winnerRepository.getWinners(quarterName);
    }
    
    @GetMapping("/draw")
    public List<Winner> draw(String quarterName) {
        
        // Draw algorithm
        // Get the leaderboard for a quarter
        // Select winners for each grade from 9th to 12th 
        // If there are more than 3 participants in a grade, randomly select 2 winners
        // If there are no student in a grade, ignore - no winnder is drawn
        // If there is only one studnet in a grade, he is the leader winner -> school reward
        // If there are exactly two students in a grade, first person is the leader winner and the second person gets the FOOD REWARD
        // If there are three students in a grade, first place gets SCHOOL REWARD, second place gets FOOD REWARD, and third place gets SCHOOL SPIRIT
        
        List<LeaderBoardPoint> leaders = pointRepository.getLeaderBoardForQuarter(quarterName);
        List<Winner> winners = new ArrayList<Winner>();
        
        Quarter quarter = quarterRepository.getQuarter(quarterName);
        
        //delete prevoius draws if any
        winnerRepository.deletePrevious(quarterName);
        
        //selection
        for(int i = 9; i <=12; i++)
        {
            int grade = i;
            List<LeaderBoardPoint> studentsInGrade = leaders.stream()
                                                            .filter(s -> s.getStudentGrade() == grade)
                                                            .collect(Collectors.toList());
            
            if (studentsInGrade == null || studentsInGrade.size() == 0)
                continue;
            
            // school item winner based on points
            Winner topInGrade = new Winner();
            topInGrade.setQuarterName(quarterName);
            topInGrade.setStudentGrade(grade);
            topInGrade.setStudentId(studentsInGrade.get(0).getStudentId());
            topInGrade.setStudentName(studentsInGrade.get(0).getStudentName());
            topInGrade.setWinnerType("LEADER WINNER");
            topInGrade.setPrizeType("SCHOOL REWARD");
            topInGrade.setPrize(quarter.getSchoolReward());

            winnerRepository.save(topInGrade);
            
            // lucky winners selection
            // choose the second & third student as lucky winner, if there is only 3 or less participants
            if (studentsInGrade.size() > 1 && studentsInGrade.size() <= 3)
            {
                Winner luckyWinnerOne = new Winner();
                luckyWinnerOne.setQuarterName(quarterName);
                luckyWinnerOne.setStudentGrade(grade);
                luckyWinnerOne.setStudentId(studentsInGrade.get(1).getStudentId());
                luckyWinnerOne.setStudentName(studentsInGrade.get(1).getStudentName());
                luckyWinnerOne.setWinnerType("LUCKY WINNER");
                luckyWinnerOne.setPrizeType("FOOD REWARD");
                luckyWinnerOne.setPrize(quarter.getFoodReward());

                winnerRepository.save(luckyWinnerOne);
                
                if (studentsInGrade.size() == 3)
                {
                    Winner luckyWinnerTwo = new Winner();
                    luckyWinnerTwo.setQuarterName(quarterName);
                    luckyWinnerTwo.setStudentGrade(grade);
                    luckyWinnerTwo.setStudentId(studentsInGrade.get(2).getStudentId());
                    luckyWinnerTwo.setStudentName(studentsInGrade.get(2).getStudentName());
                    luckyWinnerTwo.setWinnerType("LUCKY WINNER");
                    luckyWinnerTwo.setPrizeType("SCHOOL SPRIT");
                    luckyWinnerTwo.setPrize(quarter.getSchoolSprit());

                    winnerRepository.save(luckyWinnerOne);
                }
            }
            else if (studentsInGrade.size() > 3)
            {
                // more than 3 participants. choose randomly
                Random r = new Random();
                int maxRange = studentsInGrade.size();
                int r1 = r.nextInt(maxRange);
                
                
                // make sure first place winner is not randomly selected
                while(r1 == 0)
                    r1 = r.nextInt(maxRange);
                
                int r2 = 0;
                
                // make sure first place winner is not randomly selected again & same person is not selected twice
                while (r2 == 0 || r2 == r1)
                    r2 = r.nextInt(maxRange);
                
                Winner randomWinnerOne = new Winner();
                randomWinnerOne.setQuarterName(quarterName);
                randomWinnerOne.setStudentGrade(grade);
                randomWinnerOne.setStudentId(studentsInGrade.get(r1).getStudentId());
                randomWinnerOne.setStudentName(studentsInGrade.get(r1).getStudentName());
                randomWinnerOne.setWinnerType("LUCKY WINNER");
                randomWinnerOne.setPrizeType("FOOD REWARD");
                randomWinnerOne.setPrize(quarter.getFoodReward());

                winnerRepository.save(randomWinnerOne);
                
                Winner randomWinnerTwo = new Winner();
                randomWinnerTwo.setQuarterName(quarterName);
                randomWinnerTwo.setStudentGrade(grade);
                randomWinnerTwo.setStudentId(studentsInGrade.get(r2).getStudentId());
                randomWinnerTwo.setStudentName(studentsInGrade.get(r2).getStudentName());
                randomWinnerTwo.setWinnerType("LUCKY WINNER");
                randomWinnerTwo.setPrizeType("SCHOOL SPRIT");
                randomWinnerTwo.setPrize(quarter.getSchoolSprit());

                winnerRepository.save(randomWinnerTwo);
            
            }
        }

        winners = winnerRepository.getWinners(quarterName);
        return winners;
    }
}
