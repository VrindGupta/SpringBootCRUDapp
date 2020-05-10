package com.vrind.springCRUD.demo.Controller;

import com.vrind.springCRUD.demo.Entity.Student;
import com.vrind.springCRUD.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService){
        studentService=theStudentService;
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        Student theStudent= studentService.findByID(studentID);
        if(theStudent==null){
            throw new RuntimeException("Student ID not found - "+studentID);
        }
        return theStudent;
    }

    @DeleteMapping("/students/{studentID}")
    public String deleteStudent(@PathVariable int studentID){
        Student theStudent= studentService.findByID(studentID);

        if(theStudent==null){
            throw new RuntimeException("Student ID not found - "+studentID);
        }
        studentService.deleteByID(studentID);
        return "Deleted Student ID - "+studentID;
    }
}
