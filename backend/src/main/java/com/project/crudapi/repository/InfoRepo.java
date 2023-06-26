package com.project.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crudapi.model.Info;

public interface InfoRepo extends JpaRepository<Info, Long> {

}
