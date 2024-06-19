package com.gain.java.knowledge.featuresdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private Integer age;

    private Integer balance;

    private String address;
}










//@Data
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//public class Employee {
//
//    private String firstName;
//    private String lastName;
//    private Integer age;
//    private double salary;
//
//}
