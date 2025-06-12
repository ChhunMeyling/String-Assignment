package com.example.spring_ioc_demo.config;


import com.example.spring_ioc_demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean
    public List<Student> studentList() {
        return new ArrayList<>(Arrays.asList( new Student(1, "Alice Johnson", "Female", 87.5),
                new Student(2, "Bob Smith", "Male", 78.0),
                new Student(3, "Catherine Lee", "Female", 92.0),
                new Student(4, "David Brown", "Male", 85.5),
                new Student(5, "Emily Davis", "Female", 88.0)
               )

        );
    }
}

