package com.cc.testcxf2.repo;

import com.cc.testcxf2.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("PersonsRepo")
public interface PersonsRepo extends JpaRepository<Persons, Integer> {
    Persons findByName(String name);
}
