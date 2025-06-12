package com.example.spring_ioc_demo.model;

import jdk.jfr.DataAmount;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String fullName;
    private String gender;
    private Double score;
    // toString method for easy debugging
    @Override
    public String toString() {
        return
                "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                '}';
    }
}

