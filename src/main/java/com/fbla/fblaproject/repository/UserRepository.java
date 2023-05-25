/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fbla.fblaproject.repository;

import com.fbla.fblaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tharunsaravanan
 */
public interface UserRepository extends JpaRepository<User, String> {
    
    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery = true)
    User getUser(String email, String password);
}
