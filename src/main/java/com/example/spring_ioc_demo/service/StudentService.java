package com.example.spring_ioc_demo.service;

import com.example.spring_ioc_demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final List<Student> studentList;

    public StudentService(List<Student> studentList) {
        this.studentList = studentList;
    }


    public List<Student> getAllStudents() {
        return studentList;
    }


    public Student getStudentById(Integer id) {
        return studentList.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public void addStudent(Student student) {
        studentList.add(student);
    }

    // UPDATE BY ID
    public boolean updateStudentById(Integer id, Student updatedStudent) {
        Optional<Student> existingStudent = studentList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if (existingStudent.isPresent()) {
            Student s = existingStudent.get();
            s.setFullName(updatedStudent.getFullName());
            s.setGender(updatedStudent.getGender());
            s.setScore(updatedStudent.getScore());
            return true;
        }

        return false;
    }

    // DELETE BY ID
    public boolean deleteStudentById(Integer id) {
        return studentList.removeIf(student -> student.getId().equals(id));
    }
}

