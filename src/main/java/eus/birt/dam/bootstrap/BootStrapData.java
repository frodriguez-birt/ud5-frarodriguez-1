package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Address;
import eus.birt.dam.domain.Course;
import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.Tuition;
import eus.birt.dam.domain.University;
import eus.birt.dam.domain.Instructor;
import eus.birt.dam.domain.InstructorDetail;
import eus.birt.dam.domain.Project;
import eus.birt.dam.repository.CourseRepository;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.TuitionRepository;
import eus.birt.dam.repository.UniversityRepository;
import eus.birt.dam.repository.InstructorRepository;
import eus.birt.dam.repository.InstructorDetailRepository;
import eus.birt.dam.repository.ProjectRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TuitionRepository tuitionRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Transactional //Metodo con única transaccion, evita: object references an unsaved transient instance
	@Override
	public void run(String... arg0) throws Exception {
		Student student1 = new Student("Jill", "Admin","as@s");
		Address address1 = new Address("Araba Kalea", "4","Gasteiz", "01100");
		Tuition tuition1 = new Tuition(4000.0);
		University university1 = new University("EHU");
		Course course1 = new Course("Acceso a datos",4);
		
		student1.setAddress(address1);
		student1.getPhones().add("687452145");
		student1.getPhones().add("687452146");
		student1.setBirthdate(LocalDate.parse("1989-04-04"));
		university1.setAddress(address1);
		
		student1.setTuition(tuition1);
		tuition1.setStudent(student1);
		
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		
		course1.getStudents().add(student1);
		student1.getCourses().add(course1);
		
		courseRepository.save(course1);	
		universityRepository.save(university1);
		studentRepository.save(student1);
		tuitionRepository.save(tuition1);
		
		// crea un nuevo instructor y añádele un curso ya creado
		Instructor instructor1 = new Instructor("Mr.", "Pink","pink@s");
		instructor1.getCourses().add(course1);
		
		instructorRepository.save(instructor1);
		
		// crea un nuevo instructor y un nuevo instructor detail
		Instructor instructor2 = new Instructor("Mrs.", "Brown","brown@s");
		InstructorDetail instructorDetail1 = new InstructorDetail("Brown's blog","literature");
		instructor2.setInstructorDetail(instructorDetail1);
		instructorDetail1.setInstructor(instructor2);
		
		instructorRepository.save(instructor2);
		instructorDetailRepository.save(instructorDetail1);
		
		// crea un nuevo project
		Project project1 = new Project("Spring project", "IT", 10000.0);
		project1.getInstructors().add(instructor2);
		instructor2.getProjects().add(project1);
		
		projectRepository.save(project1);
		instructorRepository.save(instructor2);
		
		
		System.out.println("Started in Bootstrap");
        System.out.println("Number of Students: " + studentRepository.count());
			
	}
	
}