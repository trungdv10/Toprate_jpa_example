package com.example.demo.Service;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Model.Student;
import com.example.demo.Repository.IClassRoomRepository;
import com.example.demo.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.repository.ClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Autowired
    private IClassRoomRepository iClassRoomRepository;

    public StudentService() {
    }

    public void setDataDefault () {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "trungdv", "NA", 22));
        students.add(new Student(2, "chinhdc", "HN", 21));
        students.add(new Student(3, "ducdm", "HN", 25));
        students.add(new Student(4, "hoapt", "HCM", 20));
        iStudentRepository.saveAll(students);
    }

    public Student addStudents(Student student) {
        return iStudentRepository.save(student);
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) iStudentRepository.findAll();
    }

    public Student getStudentById(int stdId) {
        // lấy sinh viên đầu tiên trong kết quả trả về
        try {
            return iStudentRepository.findById(stdId).get();
        } catch (Exception e) {
        }
        return null;
    }

    // xoá sinh viên theo id
    public boolean deleteStudentById(int stdId) {
        // không có id này
        if (getStudentById(stdId) == null) return false;
        iStudentRepository.deleteById(stdId);
        // xóa thành công
        if (getStudentById(stdId) == null) return true;
        return false;
    }

    // Đăng ký lớp học theo id lớp học và id sinh viên
    public void registerClassForStudent(Integer idClass, Integer idStudent) {

        // lấy ra student và class theo id truyền vào
        Student student = iStudentRepository.findById(idStudent).get();
        ClassRoom classRoom = iClassRoomRepository.findById(idClass).get();

        // thêm học sinh vào lớp mới, thêm lớp vào danh sách lớp của học sinh đó
        classRoom.addStudent(student);
        student.addClass(classRoom);

        iClassRoomRepository.save(classRoom);
        iStudentRepository.save(student);

    }

    // cập nhật lớp cho sinh viên
    public void updateClass(ClassRoom classRoom){
        // lấy ra lớp học theo id
        ClassRoom updateClass = iClassRoomRepository.findById(classRoom.getId()).get();

        // check lớp có tồn tại hay không
        if(updateClass == null){
            System.out.println("Class not exist");
        }
        // cập nhật lớp cho sinh viên
        updateClass.setStudents(classRoom.getStudents());
        iClassRoomRepository.save(updateClass);
    }

}
