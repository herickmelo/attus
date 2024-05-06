package br.com.attus.desafio.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonException extends RuntimeException {

    private HttpStatusCode code;
    private String message;
    private String description;

    public PersonException(HttpStatusCode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public PersonException(HttpStatusCode code, String message, String description) {
        super(description);
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public PersonException() {

    }

    public ResponseEntity<Object> toHttpResponse() {
        return ResponseEntity
                .status(code)
                .body(new ErrorResponse(message, description));
    }

    private static class ErrorResponse {
        public ErrorResponse(String message, String description) {
        }
    }

    public static class PersonNotFoundException extends PersonException {
        public PersonNotFoundException(Long idPessoa) {
            super(HttpStatus.NOT_FOUND, "Pessoa com ID " + idPessoa + " não encontrada");
        }
    }

    public static class InvalidPersonException extends PersonException {
        public InvalidPersonException(String message) {
            super(HttpStatus.BAD_REQUEST, message);
        }
    }
}
