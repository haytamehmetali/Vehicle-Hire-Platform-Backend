package owl.vehiclehireplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import owl.vehiclehireplatform.enums.*;
import java.time.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company extends BaseEntity {
	@Column(unique = true, length = 50)
	private String name;
	
	private String logo;
	
	@Column(length = 18)
	private String taxNumber;
	
	@Column(unique = true, length = 15)
	private String phone;
	
	@Column(unique = true, length = 50)
	private String mail;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Country country;
	
	private String city;
	
	@Column(length = 200)
	private String address;
	
	private Integer postalCode;
	
	private Integer vehicleCount;
	
	private Boolean isMembershipActive;
	
	private LocalDate membershipStartDate;
	
	private LocalDate membershipEndDate;
	
	@Enumerated(EnumType.STRING)
	private CompanyMembershipType companyMembershipType;
	
	@Enumerated(EnumType.STRING)
	private CompanyState companyState;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Car> cars;
}
