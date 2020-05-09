package com.vrind.springCRUD.demo.Service;

import com.vrind.springCRUD.demo.DAO.StudentDAO;
import com.vrind.springCRUD.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Student findByID(int theID) {
        return studentDAO.findByID(theID);
    }

    @Override
    @Transactional
    public void deleteByID(int theID) {
        studentDAO.deleteByID(theID);
    }
}
