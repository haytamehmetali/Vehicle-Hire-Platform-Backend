package owl.vehiclehireplatform.utility;

import org.springframework.stereotype.*;
import java.util.*;
import java.util.stream.*;

@Service
public class CodeGenerator {
	public String generateCode() {
		String uuid = UUID.randomUUID().toString();
		return Arrays.stream(uuid.split("-")).map(segment -> String.valueOf(segment.charAt(0)))
		             .collect(Collectors.joining());
	}
}
