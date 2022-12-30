package com.example.mongoPc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="customer Not Found")
public class CustomerNotFoundException extends Exception{
}
