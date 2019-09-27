package com.cognizant.learn.projectManager.exception;

import com.cognizant.learn.projectManager.model.ErrorDetail;
import com.cognizant.learn.projectManager.util.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.cognizant.learn.projectManager")
public class RestExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleException(Exception e) {
        logger.error(e.getMessage(),e);
        String message = Translator.toLocale(e.getMessage(), new Object[]{} );
        return new ResponseEntity<>(new ErrorDetail(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorDetail> handleDuplicateException(DuplicateException e){
        String message = Translator.toLocale(e.getMessage(), new Object[]{e.getId()} );
        return new ResponseEntity<>(new ErrorDetail(message), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleEntityNotFoundException(EntityNotFoundException e){
        String message = Translator.toLocale(e.getMessage(), new Object[]{e.getId()} );
        return new ResponseEntity<>(new ErrorDetail(message), HttpStatus.NOT_FOUND);
    }
}
