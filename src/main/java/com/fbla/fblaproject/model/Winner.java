/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tharun Saravanan
 */
@Entity
public class Winner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String quarterName;
    private int studentId;
    private int studentGrade;
    private String studentName;
    private String winnerType;
    private String prizeType;
    private String prize;

    public Winner() {
    }
    
    public int getId() {
        return id;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getWinnerType() {
        return winnerType;
    }

    public void setWinnerType(String winnerType) {
        this.winnerType = winnerType;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
