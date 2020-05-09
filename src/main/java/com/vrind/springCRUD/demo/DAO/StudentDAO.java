package com.vrind.springCRUD.demo.DAO;

import com.vrind.springCRUD.demo.Entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();

    public Student findByID(int theID);

    public void deleteByID(int theID);
}
