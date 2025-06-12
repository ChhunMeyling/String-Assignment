package com.example.spring_ioc_demo;

import com.example.spring_ioc_demo.model.Student;
import com.example.spring_ioc_demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIocDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringIocDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(StudentService studentService) {
		return args -> {

			System.out.println("=== Initial Students ===");
			studentService.getAllStudents().forEach(System.out::println);

			System.out.println("\n=== Get Student By ID (3) ===");
			System.out.println("\n			============== The Output is ==================");
			System.out.println(studentService.getStudentById(3));

			System.out.println("\n=== Add New Student ===");
			System.out.println("\n			============== The Output is ==================");
			Student newStudent = new Student(11, "Leo Carter", "Male", 80.5);
			studentService.addStudent(newStudent);
			studentService.getAllStudents().forEach(System.out::println);

			System.out.println("\n=== Update Student ID (2) ===");
			Student updated = new Student(2, "Bob Smith Jr.", "Male", 85.0);
			boolean updatedStatus = studentService.updateStudentById(2, updated);
			System.out.println("Update Successful: " + updatedStatus);
			System.out.println("\n			============== The Output is ==================");
			studentService.getAllStudents().forEach(System.out::println);

			System.out.println("\n=== Delete Student ID (1) ===");
			boolean deletedStatus = studentService.deleteStudentById(1);
			System.out.println("Delete Successful: " + deletedStatus);
			System.out.println("\n			============== The Output is ==================");
			studentService.getAllStudents().forEach(System.out::println);
		};
	}
}
