package com.payconiq.stocks.exception;

import com.payconiq.stocks.constants.StockMessageCode;

public class NoDataFoundException extends RuntimeException{

	private static final long serialVersionUID = -2543315756756890974L;
	
	private final StockMessageCode stockMessageCode;

	public StockMessageCode getStockMessageCode() {
		return stockMessageCode;
	}

	public NoDataFoundException(String message, StockMessageCode stockMessageCode) {
		super(message);
		this.stockMessageCode = stockMessageCode;
	}
}
