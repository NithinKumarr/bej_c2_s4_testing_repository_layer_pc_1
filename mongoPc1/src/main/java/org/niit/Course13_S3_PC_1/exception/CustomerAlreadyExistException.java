package org.niit.Course13_S3_PC_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Customer already exist")
public class CustomerAlreadyExistException extends Exception{

}
