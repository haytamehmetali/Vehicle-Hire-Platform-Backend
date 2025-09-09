package owl.vehiclehireplatform.exception;

import lombok.Getter;

@Getter
public class VehicleHireException extends RuntimeException {
	private final ErrorType errorType;
	
	public VehicleHireException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}
