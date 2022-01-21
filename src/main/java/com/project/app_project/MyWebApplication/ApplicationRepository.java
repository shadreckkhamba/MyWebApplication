package com.project.app_project.MyWebApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository
        extends JpaRepository<MyWebApplication, Long> {
    @Query("SELECT s FROM MyWebApplication s WHERE s.name = ?1")
    Optional<MyWebApplication>findMyWebApplicationByName(String name);
    @Query("SELECT s FROM MyWebApplication s WHERE s.email=?1")
    <myWebApplication> Optional<myWebApplication> findMyWebApplicationByEmail(String email);

 // Optional<Object> findByName(String myWebApplicationName);
public List<MyWebApplication> findByName(String name);
}