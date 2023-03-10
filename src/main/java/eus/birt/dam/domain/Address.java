package eus.birt.dam.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	
	public Address() {
		
	}
	
	public Address(String addressLine1, String addressLine2, String city, String zipCode) {
		//super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
	}

	@Column (name ="address_line_1")
	private String addressLine1;
	
	@Column (name ="address_line_2")
	private String addressLine2;
	
	@Column (name ="city")
	private String city;
	
	@Column (name ="zip_code")
	private String zipCode;
	
}
