package it.epicode.w7d1c.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundExceptionHandler(NotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse ExceptionHandler(IOException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestExceptionHandler(BadRequestException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(DispositiviManutenzioneException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse DispositioManutenzioneException(DispositiviManutenzioneException e) {
        return new ErrorResponse(e.getMessage());
    }

        @ExceptionHandler(UnAuthorizedException.class)
        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        public ErrorResponse unAuthorizedExceptionHandler (UnAuthorizedException e){
            return new ErrorResponse(e.getMessage());

        }
    }
