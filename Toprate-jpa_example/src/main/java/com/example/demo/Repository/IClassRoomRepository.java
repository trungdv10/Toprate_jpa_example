package com.example.demo.Repository;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

}
