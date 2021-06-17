package com.lean.tech.java.Employees.config;

public class EmployeeException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable exception) {
        super(message, exception);
    }
}

