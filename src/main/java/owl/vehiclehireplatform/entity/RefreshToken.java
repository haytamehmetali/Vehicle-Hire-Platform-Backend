package owl.vehiclehireplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long authId;
	
	@Column(unique = true, nullable = false, length = 512)
	private String token;
	
	private LocalDateTime expiryDate;
}
