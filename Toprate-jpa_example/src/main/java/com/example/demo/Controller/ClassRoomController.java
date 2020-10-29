package com.example.demo.Controller;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Model.Student;
import com.example.demo.Service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    // lấy ra danh sách lớp học
    @GetMapping("/classroom/list")
    public List<ClassRoom> findAllClassRoom() {
        return classRoomService.getAllClassRoom();
    }

    // lấy ra tòa bộ học sinh của lớp học theo id lớp học
    @RequestMapping(value = "/classroom/{stdId}", method = RequestMethod.GET)
    public List<Student> findAllClass(@PathVariable(name = "stdId") Integer stdId) {
        return classRoomService.getAllStudentByIdClass(stdId);
    }
}
