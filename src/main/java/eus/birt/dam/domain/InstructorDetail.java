package eus.birt.dam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table (name="instructor_detail")
public class InstructorDetail extends BaseEntity{

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Column(name="blog")
	private String blog;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail")
	private Instructor instructor;
	
	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String blog, String hobby) {
		this.blog = blog;
		this.hobby = hobby;
	}

}
