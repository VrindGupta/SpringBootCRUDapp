package com.vrind.springCRUD.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vrind.springCRUD.demo.Entity.Student;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public StudentDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Student> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Student> theQuery =
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
		
		// return the results		
		return students;
	}


	@Override
	public Student findByID(int theID) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Student theStudent =
				currentSession.get(Student.class, theID);
		
		// return the employee
		return theStudent;
	}



	@Override
	public void deleteByID(int theID) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theID);
		
		theQuery.executeUpdate();
	}

}







