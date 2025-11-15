package com.example.controller;

import com.example.model.Student;
import com.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("all")
    public List<Student> getStudents() {
        return  studentRepo.findAll();

    }
    @PostMapping("add")
    public Student addStudnet(@RequestBody Student student) {
        return studentRepo.save(student);
    }
    @GetMapping("get/{id}")
    public Student getBy(@PathVariable("id")int id){
        return  studentRepo.findById(id).get();
    }
    @PutMapping("update/{id}")

    public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student){
        Optional<Student> student1=studentRepo.findById(id);
        return studentRepo.save(student);
    }

}
