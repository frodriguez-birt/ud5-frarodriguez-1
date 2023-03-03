package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
