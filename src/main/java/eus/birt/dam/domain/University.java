package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table (name="university")
public class University extends BaseEntity{
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Column (name= "name")
	private String name;
		
	@Embedded
	private Address address;
	
	@OneToMany
	@JoinColumn (name = "university_id")
	List <Student> students = new ArrayList<>();

	public University(String name) {
		//super();
		this.name = name;
	}
	
}
