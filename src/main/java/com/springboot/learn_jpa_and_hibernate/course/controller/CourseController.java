package com.springboot.learn_jpa_and_hibernate.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learn_jpa_and_hibernate.course.Course;
import com.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}

	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	@GetMapping("/courses/{id}")
	public Course getCourse1(@PathVariable long id) {

		Optional<Course> course = repository.findById(id);
		if (course.isEmpty()) {
			throw new RuntimeException("Course is not found");
		}
		return course.get();

	}

	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
}
