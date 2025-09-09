package owl.vehiclehireplatform.exception;

import lombok.extern.slf4j.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.regex.*;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(VehicleHireException.class)
	public ResponseEntity<ErrorMessage> handleVehicleHireException(VehicleHireException e) {
		return createResponseEntity(e.getErrorType(),
									e.getErrorType().getHttpStatus(),
									null);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException e) {
		return createResponseEntity(ErrorType.INTERNAL_ERROR,
		                            HttpStatus.INTERNAL_SERVER_ERROR,
		                            List.of(e.getMessage()));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return createResponseEntity(ErrorType.JSON_CONVERT_ERROR,
		                            ErrorType.JSON_CONVERT_ERROR.getHttpStatus(),
		                            null);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> fieldErrors = new ArrayList<>();
		
		e.getBindingResult().getFieldErrors()
		 .forEach(fieldError -> {
			 fieldErrors.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
		 });
		
		return createResponseEntity(ErrorType.VALIDATION_EXCEPTION,
		                            HttpStatus.BAD_REQUEST,
		                            fieldErrors);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorMessage> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		String message = e.getMessage();
		String extractedMessage = extractDuplicateKeyMessage(message);
		
		// Unique
		if (extractedMessage != null) {
			return createResponseEntity(ErrorType.DUPLICATE_KEY,
			                            HttpStatus.BAD_REQUEST,
			                            List.of(extractedMessage));
		}
		
		// Others
		return createResponseEntity(ErrorType.DATA_INTEGRITY_ERROR,
		                            HttpStatus.BAD_REQUEST,
		                            List.of(e.getMessage()));
	}
	
	private String extractDuplicateKeyMessage(String errorMessage) {
		if (errorMessage == null) return null;
		
		Pattern pattern = Pattern.compile("Key \\(\\w+\\)=\\(.*?\\) already exists\\.");
		Matcher matcher = pattern.matcher(errorMessage);
		
		if (matcher.find()) {
			return matcher.group(0);
		}
		
		return null;
	}
	
	public ResponseEntity<ErrorMessage> createResponseEntity(ErrorType errorType, HttpStatus httpStatus, List<String> fieldErrors) {
		log.error("Tüm Hataların Geçtiği Metot: " + errorType.getCode() + " : " + errorType.getMessage() + " - " + fieldErrors);
		return new ResponseEntity<>(ErrorMessage.builder()
		                                        .code(errorType.getCode())
		                                        .message(errorType.getMessage())
		                                        .success(false)
		                                        .details(fieldErrors).build(), httpStatus);
	}
	
}
