package com.classrom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.classrom.app.entity.ClassRoom;

@Component
public interface ClassRepository extends JpaRepository<ClassRoom, Long>{

}