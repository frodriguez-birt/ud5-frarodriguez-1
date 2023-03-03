package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
