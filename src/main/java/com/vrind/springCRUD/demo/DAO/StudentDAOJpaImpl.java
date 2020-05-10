package com.vrind.springCRUD.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vrind.springCRUD.demo.Entity.Student;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Student> findAll() {

		// create a query
		Query theQuery = 
				entityManager.createQuery("from Student");
		
		// execute query and get result list
		List<Student> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}

	@Override
	public Student findByID(int theId) {

		// get employee
		Student theStudent =
				entityManager.find(Student.class, theId);
		
		// return employee
		return theStudent;
	}

	@Override
	public void deleteByID(int theID) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from Student where id=:employeeID");
		
		theQuery.setParameter("studentId", theID);
		
		theQuery.executeUpdate();
	}

}










