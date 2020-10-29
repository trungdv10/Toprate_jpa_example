package com.example.demo.Service;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Model.Student;
import com.example.demo.Repository.IClassRoomRepository;
import com.example.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class ClassRoomService {

    @Autowired
    private IClassRoomRepository classRoomRepository;

    @Autowired
    private IStudentRepository studentRepository;

    public List<ClassRoom> getAllClassRoom() {
        return classRoomRepository.findAll();
    }

    public List<Student> getAllStudentByIdClass(Integer idClass) {
        List<Student> studentList = studentRepository.findAllStudentByIdClass(idClass);

        return studentList;
    }

}
