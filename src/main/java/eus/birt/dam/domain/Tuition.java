package eus.birt.dam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name="tuition")
public class Tuition extends BaseEntity{

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column (name="fee")
	private Double fee;
	
	@OneToOne
	@JoinColumn(name="student_id", referencedColumnName="id")
	private Student student;
	
	public Tuition() {
		
	}

	public Tuition(Double fee) {
		//super();
		this.fee = fee;
	}

	
	
}
