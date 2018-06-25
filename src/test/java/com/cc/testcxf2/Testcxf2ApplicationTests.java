package com.cc.testcxf2;

import com.cc.testcxf2.entity.Persons;
import com.cc.testcxf2.repo.PersonsRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class Testcxf2ApplicationTests {
    @Autowired
    PersonsRepo personsRepo;
    @Test
    public void add(){
        Persons p1 = new Persons();
        p1.setId(1);
        p1.setName("ttt");
        personsRepo.save(p1);
        Persons p = personsRepo.findByName("tt");
    }
}
