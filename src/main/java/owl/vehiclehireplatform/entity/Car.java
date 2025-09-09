package owl.vehiclehireplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import owl.vehiclehireplatform.enums.*;
import java.math.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Rental rental;
	
	@Column(nullable = false, length = 30)
	private String brand;
	
	@Column(nullable = false, length = 30)
	private String model;
	
	@Column(unique = true, nullable = false)
	private String plate;
	
	@Column(nullable = false)
	private BigDecimal dailyPrice;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	
	@Column(nullable = false)
	private Boolean isAutomatic;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleStatus vehicleStatus;
}
