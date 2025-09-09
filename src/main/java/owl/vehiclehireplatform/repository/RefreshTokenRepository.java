package owl.vehiclehireplatform.repository;

import org.springframework.data.jpa.repository.*;
import owl.vehiclehireplatform.entity.*;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	
	void deleteByToken(String token);
}
