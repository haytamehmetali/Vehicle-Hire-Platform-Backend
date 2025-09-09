package owl.vehiclehireplatform.exception;

import lombok.*;
import org.springframework.http.*;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorType {
	DUPLICATE_KEY(5000, "Aynı benzersiz alana sahip bir kayıt zaten mevcut! Lütfen farklı değerler kullanın!", CONFLICT),
	DATA_INTEGRITY_ERROR(5001, "Veri bütünlüğü hatası! Tutarsız veya çelişkili veriler nedeniyle işlem tamamlanamadı!", CONFLICT),
	VALIDATION_EXCEPTION(5002, "Bir veya birden fazla alan geçersiz! Lütfen giriş bilgilerinizi kontrol ederek tekrar deneyin!", UNPROCESSABLE_ENTITY),
	JSON_CONVERT_ERROR(5003, "Geçersiz giriş parametreleri! JSON verisi çözümlenemedi!", BAD_REQUEST),
	INTERNAL_ERROR(5005, "Sunucuda beklenmeyen bir hata oluştu! Lütfen daha sonra tekrar deneyin!", INTERNAL_SERVER_ERROR),
	
	
	
	
	// FINISH
	FINISH(0, "THE END!", OK);
	
	int code;
	String message;
	HttpStatus httpStatus;
}
