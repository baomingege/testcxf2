package com.cc.testcxf2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persons")
public class Persons implements Serializable {
    @Id
    private Integer id;
    private String name;
}
