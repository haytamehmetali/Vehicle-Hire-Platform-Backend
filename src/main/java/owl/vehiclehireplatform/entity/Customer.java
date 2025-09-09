package owl.vehiclehireplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import owl.vehiclehireplatform.enums.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer extends BaseEntity {
	@Column(unique = true, length = 50)
	private String mail;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String surname;
	
	@Column(length = 18)
	private String identificationNumber;
	
	@Column(unique = true, length = 15)
	private String phone;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Country country;
	
	private String city;
	
	@Column(length = 200)
	private String address;
	
	private Integer postalCode;
}
