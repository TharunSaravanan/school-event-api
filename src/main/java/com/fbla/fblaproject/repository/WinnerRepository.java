/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.Event;
import com.fbla.fblaproject.model.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tharun Saravanan
 */
public interface WinnerRepository extends JpaRepository<Winner,Integer>  {
    
}
