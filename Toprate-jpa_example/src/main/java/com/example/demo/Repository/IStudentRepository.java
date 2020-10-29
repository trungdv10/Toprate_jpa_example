package com.example.demo.Repository;



import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student AS s JOIN class_room AS c JOIN students_classrooms AS sc WHERE c.id = sc.classroom_id AND sc.student_id = s.id AND c.id = :id",nativeQuery = true)
    List<Student> findAllStudentByIdClass(@Param("id") Integer id);
}
