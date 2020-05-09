package com.vrind.springCRUD.demo.Service;

import com.vrind.springCRUD.demo.Entity.Student;

import java.util.List;

public interface StudentService  {
    public List<Student> findAll();

    public Student findByID(int theID);

    public void deleteByID(int theID);
}
