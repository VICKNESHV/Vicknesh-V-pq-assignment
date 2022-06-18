package com.payconiq.stocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.payconiq.stocks.constants.StockMessageCode;
import com.payconiq.stocks.model.StatusMessage;
import com.payconiq.stocks.model.StatusMessage.TypeEnum;
import com.payconiq.stocks.model.StatusMessageResponse;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	//@ExceptionHandler(Exception.class)
	public final ResponseEntity<StatusMessageResponse> handleAllException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(StockMessageCode.INTERNAL_ERROR.getDescription());
		statusMessage.setCode(StockMessageCode.INTERNAL_ERROR.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StockException.class)
	public final ResponseEntity<StatusMessageResponse> handleStockException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(StockMessageCode.INTERNAL_ERROR.getDescription());
		statusMessage.setCode(StockMessageCode.INTERNAL_ERROR.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<StatusMessageResponse> handleNoDataFoundException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(StockMessageCode.NO_DATA_FOUND.getDescription());
		statusMessage.setCode(StockMessageCode.NO_DATA_FOUND.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.NOT_FOUND);
	}

}
