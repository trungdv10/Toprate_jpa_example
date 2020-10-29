package com.example.demo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class_room")
public class ClassRoom {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "room")
    private String room;

    @Column(name = "teacher")
    private String teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "students_classrooms",
            joinColumns = {
                    @JoinColumn(name = "student_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "classroom_id")})
    @Transient
    private List<Student> students = new ArrayList<>();

    public ClassRoom() {

    }

    public ClassRoom(int id, String subject, String room, String teacher) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
