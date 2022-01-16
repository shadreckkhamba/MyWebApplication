package com.example.demo.MyWebApplication.AppRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppRepository extends JpaRepository<myWebApplication, Long>{

}
