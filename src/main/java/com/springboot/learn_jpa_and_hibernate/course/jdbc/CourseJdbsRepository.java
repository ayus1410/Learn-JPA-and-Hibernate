package com.springboot.learn_jpa_and_hibernate.course.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.learn_jpa_and_hibernate.course.Course;

@Repository // This talks to database
public class CourseJdbsRepository {

	private static String INSERT_QUERY = """
				insert into course(id, name, author)
				values(?,?,?);
			""";

	private static String DELETE_QUERY = """
				delete from course
				where id = ?;
			""";

	private static String SELECT_QUERY = """
			select * from course
			where id = ?;
			""";

//	@Autowired
	private JdbcTemplate springJdbsTemplate;

//	public void insert(Course course) {
//		springJdbsTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
//	}

	public void deleteById(long id) {
		springJdbsTemplate.update(DELETE_QUERY, id);
	}

	public Course findById(long id) {
		return springJdbsTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		// Resultset -> Bean -> Row Mapper ->
	}

	public void insert(List<Course> courses) {
		for (Course course : courses) {
			springJdbsTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
		}
	}
}
