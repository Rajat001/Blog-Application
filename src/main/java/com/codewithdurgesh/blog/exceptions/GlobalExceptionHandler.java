package com.codewithdurgesh.blog.exceptions;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Exceptional handler class is called here ...
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // handling this class for now ...
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage(); // Resource Not found exception will came here for not found ...
        ApiResponse apiResponse = new ApiResponse(message , false);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.NOT_FOUND);
    }


    // Neechae wala exeption hoga for validation k liae , username , email ye sab shi hona chahiae
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidaException(MethodArgumentNotValidException ex)
    {
        Map<String , String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName , message);
        });

        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }
}
