package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="instructor")
public class Instructor extends BaseEntity{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	private Address address;
	
	@OneToMany
	@JoinColumn (name = "instructor_id")
	private Set<Course> courses = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="instructor_detail_id", referencedColumnName="id")
	private InstructorDetail instructorDetail;
	
	@ManyToMany 
	@JoinTable(name="instructor_project", joinColumns=@JoinColumn(name="instructor_id"), 
			inverseJoinColumns=@JoinColumn(name="project_id"))
	private Set<Project> projects = new HashSet<>();
	
	public Set<Course> getCourses() {
		return courses;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}	
}
