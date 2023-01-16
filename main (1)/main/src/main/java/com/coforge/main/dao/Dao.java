package com.coforge.main.dao;

import com.coforge.main.entities.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  Dao extends JpaRepository<Entity, Integer> {

    @Query("select e from Entity e where e.ou = ?1 and e.service_line = ?2")
    List<Entity> findByOuAndService_line(String ou, String service_line);
    List<Entity> findByOu(String ou);

}

