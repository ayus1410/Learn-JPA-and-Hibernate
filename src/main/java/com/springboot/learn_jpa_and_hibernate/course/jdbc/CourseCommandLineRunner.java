package com.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learn_jpa_and_hibernate.course.Course;
import com.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbsRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "Ayush"));
		repository.save(new Course(2, "Learn Spring", "Akash"));
		repository.save(new Course(3, "Learn Spring boot", "Shlok"));

//		repository.deleteById(2l);

//		System.out.println(repository.findById(1l));
//		System.out.println(repository.findById(3l));

//		System.out.println(repository.findAll());
//		System.out.println(repository.count());
//
//		System.out.println(repository.findByAuthor("Ayush")); // This is a custom method(created by us)
	}

}
