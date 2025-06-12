package com.example.spring_ioc_demo;

import com.example.spring_ioc_demo.model.Student;
import com.example.spring_ioc_demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SpringIocDemoApplication  {

	public static void main(String[] args) {

		SpringApplication.run(SpringIocDemoApplication.class, args) ;
	}
	@Bean
	public CommandLineRunner run(StudentService studentService) {
		return args -> {
			while(true) {
				System.out.println("""
						1. Show all students
						2. get student by ID
						3. Add new student
						4. Update student
						5. Delete student
						""");
				System.out.print("[+] Inter Option : ");
				int op = new Scanner(System.in).nextInt();
				switch (op) {
					case 1: {
						studentService.getAllStudents().forEach(System.out::println);

						break;
					}
					case 2: {
						System.out.print("Enter student ID : ");
						int sid = new Scanner(System.in).nextInt();
						//studentService.getStudentById(sid);
						System.out.println(studentService.getStudentById(sid));
						break;
					}
					case 3: {
						System.out.print("Enter student ID : ");
						int id = new Scanner(System.in).nextInt();
						System.out.print("Enter student name : ");
						String name = new Scanner(System.in).nextLine();
						System.out.print("Enter student Gender : ");
						String gender = new Scanner(System.in).nextLine();
						System.out.print("Enter Student Score : ");
						double score = new Scanner(System.in).nextDouble();
						Student newstudent = new Student(id, name, gender, score);
						studentService.addStudent(newstudent);
						System.out.println("\n [+] Student Added Successfully !!");
						break;
					}
					case 4 : {
						System.out.print("Enter student ID to Update : ");
						int oid = new Scanner(System.in).nextInt();
						System.out.println("============== INSERT STUDENT ================");
						System.out.print("Enter student ID : ");
						int nid = new Scanner(System.in).nextInt();
						System.out.print("Enter student name : ");
						String name = new Scanner(System.in).nextLine();
						System.out.print("Enter student Gender : ");
						String gender = new Scanner(System.in).nextLine();
						System.out.print("Enter Student Score : ");
						double score = new Scanner(System.in).nextDouble();
						Student updatestudent = new Student(nid, name, gender, score);
						studentService.updateStudentById(oid, updatestudent);
						System.out.println("\n [+] Student Updated Successfully !!");
						break;
					}
					case 5: {
						System.out.print("Enter student ID to Delete : ");
						int oid = new Scanner(System.in).nextInt();
						studentService.deleteStudentById(oid);
						System.out.println("\n [+] Student Deleted Successfully !!");
						break;
					}
					default: {
						System.out.println("Invalid Option !!");
					}

				}
			}

		};
	}


}
