package com.lean.tech.java.Employees.config;

import java.util.NoSuchElementException;

import com.lean.tech.java.Employees.common.ErrorsCodeEnum;
import com.lean.tech.java.Employees.common.Utils;
import com.lean.tech.java.Employees.dto.ErrorResponseDTO;
import com.lean.tech.java.Employees.services.impl.EmployeeServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@org.springframework.web.bind.annotation.ExceptionHandler({ IllegalArgumentException.class,
			IllegalStateException.class })
	public ResponseEntity<Object> handleMethodInternalError(Exception ex, WebRequest request) {
		ErrorResponseDTO errors = Utils.errorResponse("Error in the transaction: [" + ex.getMessage() + "]", "InternalError",ErrorsCodeEnum.INTERNAL_SERVER_ERROR.getCode());
		LOG.error("Error", ex);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({ NoSuchElementException.class,
			NullPointerException.class })
	public ResponseEntity<Object> handleMethodNoDataFound(Exception ex, WebRequest request) {
		ErrorResponseDTO errors = Utils.errorResponse("Datos no encontrados: [" + ex.getMessage() + "]", "InternalError",ErrorsCodeEnum.NOT_FOUND.getCode());
		LOG.error("Error", ex);
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
