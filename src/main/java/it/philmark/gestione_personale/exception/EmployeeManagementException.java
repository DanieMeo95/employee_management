package it.philmark.gestione_personale.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeManagementException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public EmployeeManagementException(String message, HttpStatus status) {
        this.setMessage(message);
        this.setStatus(status);
    }

    public EmployeeManagementException(String message) { this(message, HttpStatus.INTERNAL_SERVER_ERROR); }

//    public EmployeeManagementException(MessageDto messageDto) { this(messageDto.getContent(), messageDto.getStatus()); }

    public EmployeeManagementException(BindingResult bindingResult) {
        this.setMessage(getErrorMessages(bindingResult));
        this.setStatus(HttpStatus.BAD_REQUEST);
    }

    public EmployeeManagementException(Exception ex) {
        this.setMessage(ex.getMessage());
    }

    private String getErrorMessages(BindingResult bindingResult) {
        StringBuilder messages = new StringBuilder();
        bindingResult.getFieldErrors().forEach(error -> {
            messages.append(error.getDefaultMessage()).append("\n");
        });
        return messages.toString();
    }
}
