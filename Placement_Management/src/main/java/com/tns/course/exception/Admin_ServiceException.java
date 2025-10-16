package com.tns.course.exception;

@SuppressWarnings("serial")
public class Admin_ServiceException extends RuntimeException {

    public Admin_ServiceException(String message) {
        super(message);
    }

    public Admin_ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
