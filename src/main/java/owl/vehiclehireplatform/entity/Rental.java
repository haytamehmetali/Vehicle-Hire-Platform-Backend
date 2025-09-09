package owl.vehiclehireplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import owl.vehiclehireplatform.enums.*;
import java.math.*;
import java.time.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental")
public class Rental extends BaseEntity{
	private Long carId;
	
	private Long customerId;
	
	@Column(nullable = false)
	private Integer rentalPeriod;
	
	@Column(nullable = false)
	private BigDecimal totalPrice;
	
	@Column(nullable = false)
	private LocalDateTime rentalDate;
	
	@Column(nullable = false)
	private LocalDateTime deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private ReservationType reservationType;
	
	// PAYMENT
	private String cardholdersName;   // Kart sahibinin adı
	private String cardNumber;        // Kart numarası
	private Integer expiryMonth;      // Son kullanma ayı (MM)
	private Integer expiryYear;       // Son kullanma yılı (YYYY)
	private String cvc;               // Kartın güvenlik kodu (3 haneli)
}
