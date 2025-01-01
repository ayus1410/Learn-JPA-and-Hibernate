package com.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void deleteById(long id) {
		entityManager.remove(entityManager.find(Course.class, id));
	}

	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	public void insert(Course course) {
		entityManager.merge(course);
	}
}