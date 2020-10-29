package com.example.demo.Controller;

import com.example.demo.Model.ResponseDelete;
import com.example.demo.Model.Student;
import com.example.demo.Repository.IStudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;     // singleton service sinh viên

    @Autowired
    private IStudentRepository studentRepository;

    // lấy ra dnh sách sinh viên
    @GetMapping("students/list")
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> temp = studentService.getAllStudents();
        if (temp.size() == 0) {
            studentService.setDataDefault();
            temp = studentService.getAllStudents();
        }
        return temp;
    }

    // tìm sinh viên theo id
    @GetMapping("student/{stdId}")
    public Student getStudentById(@PathVariable int stdId) {
        return studentService.getStudentById(stdId);
    }

    // xóa sinh viên theo id
    @GetMapping("student/delete/{stdId}")
    public ResponseDelete deleteStudentById(@PathVariable int stdId) {
        ResponseDelete responseDelete = new ResponseDelete();
        responseDelete.setSucess(studentService.deleteStudentById(stdId));
        return responseDelete;
    }

    // Đăng ký môn học theo id
    @RequestMapping(value = "/student/{clsId}/{stdId}", method = RequestMethod.POST)
    public String registerClass(@PathVariable(name = "stdId") Integer stdId, @PathVariable(name = "clsId") Integer clsId) {
        studentService.registerClassForStudent(clsId, stdId);
        return "register success";
    }


}
