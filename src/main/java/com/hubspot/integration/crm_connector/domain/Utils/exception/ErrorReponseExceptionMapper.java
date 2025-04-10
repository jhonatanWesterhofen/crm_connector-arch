package com.hubspot.integration.crm_connector.domain.Utils.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorReponseExceptionMapper {

    @ExceptionHandler(ConnectorException.class)
    public ResponseEntity<ErrorResponseDTO> handleConnectorException(ConnectorException ex) {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String message = ex.getMessage();
        String code = ex.getErrorCode();
        String httpStatus = HttpStatus.BAD_REQUEST.name();

        ErrorResponseDTO dto = new ErrorResponseDTO(message, timestamp, code, httpStatus);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}