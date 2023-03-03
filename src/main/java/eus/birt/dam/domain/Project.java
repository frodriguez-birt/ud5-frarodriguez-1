package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table (name="project")
public class Project extends BaseEntity{

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	@Column (name= "name")
	private String name;
	
	@Column (name= "field")
	private String field;
	
	@Column (name="budget")
	private Double budget;
	
	@ManyToMany (mappedBy="projects")
	private Set<Instructor> instructors = new HashSet<>();
	
	public Project() {
	
	}
	
	public Project(String name, String field, Double budget) {
		this.name = name;
		this.field = field;
		this.budget = budget;
	}
}
