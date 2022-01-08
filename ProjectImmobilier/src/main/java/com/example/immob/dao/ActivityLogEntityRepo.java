package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.immob.entities.ActivityLogEntity;

@Repository
public interface ActivityLogEntityRepo extends JpaRepository<ActivityLogEntity,Long>{

}
