package com.cc.testcxf2.service;

import com.cc.testcxf2.entity.Persons;
import com.cc.testcxf2.repo.PersonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
//@Service("PersonsService")
public class PersonsServiceImp implements PersonsService{
    //public static PersonsServiceImp personsServiceImp;

    @Autowired
    private PersonsRepo personsRepo;
//    public void setPersonsRepo(PersonsRepo personsRepo){
//        this.personsRepo = personsRepo;
//    }
//    @PostConstruct
//    public void init(){
//        personsServiceImp = this;
//        //personsServiceImp.personsRepo = this.personsRepo;
//    }
    @Override
    public Persons add(Integer id,String name){
        Persons p1 = new Persons();
        p1.setId(12);
        p1.setName("tttt");
        Persons p2=personsRepo.findByName("ttt");
        //List<Persons> list = personsRepo.findAll();
        return p2;
    }
}
