/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.model;

/**
 *
 * @author Tharun Saravanan
 
public class LeaderBoardPoint {
    private int studentId;
    private int studentName;
    private int grade;
    private int totalPoints;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentName() {
        return studentName;
    }

    public void setStudentName(int studentName) {
        this.studentName = studentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public LeaderBoardPoint() {
    }
}*/

public interface LeaderBoardPoint{
    int getStudentId();
    int getStudentGrade();
    String getStudentName();
    int getTotalPoints();
}
