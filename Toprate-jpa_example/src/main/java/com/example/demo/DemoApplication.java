package com.example.demo;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Model.Student;
import com.example.demo.Repository.IClassRoomRepository;
import com.example.demo.Repository.IStudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IClassRoomRepository classRoomRepository;

//    @Bean
//    public CommandLineRunner mappingDemo(IStudentRepository studentRepository,
//                                         IClassRoomRepository classRoomRepository) {
//        return args -> {
//
//            // Create an student
//            Student student1 = new Student();
//            student1.setId(102);
//            student1.setName("Ramesh");
//            student1.setAddress("HN");
//            student1.setAge(22);
//
//            Student student2 = new Student(109, "trungdv", "Hn", 22);
//            Student student3 = new Student(202, "chinhdc", "NA", 18);
//
//            // save the student
//            studentRepository.saveAll(Arrays.asList(student1,student2,student3));
//
//            // Create clasRoom1
//            ClassRoom classRoom1 = new ClassRoom();
//            classRoom1.setId(198);
//            classRoom1.setRoom("t106");
//            classRoom1.setSubject("Math");
//            classRoom1.setTeacher("trungdv10");
//
////
//            // Create classRoom2
//            ClassRoom classRoom2 = new ClassRoom();
//            classRoom2.setId(202);
//            classRoom2.setRoom("rh302");
//            classRoom2.setSubject("history");
//            classRoom2.setTeacher("chinhdvc");
//
//            // save classrooms
//            classRoomRepository.saveAll(Arrays.asList(classRoom1, classRoom2));
//
//            // add students to the class
//            classRoom1.getStudents().addAll(Arrays.asList(student1, student2, student3));
//
//            // update the student
//            classRoomRepository.save(classRoom2);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
