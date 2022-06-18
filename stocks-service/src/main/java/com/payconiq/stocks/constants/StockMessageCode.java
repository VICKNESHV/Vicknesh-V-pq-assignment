package com.payconiq.stocks.constants;

public enum StockMessageCode {
	
	SYSTEM_ERROR("STOCK9000", "System error occured during request processing"),
	INTERNAL_ERROR("STOCK9001", "Internal error occured during request processing"),
	INVALID("STOCK9002", "Invalid request, please check the request input"),
	NO_DATA_FOUND("STOCK9004", "Stock not found"),
	SUCCESSFUL_UPDATION("STOCK9005", "Stock is successfully updated into the database"),
	SUCCESSFUL_ADDITION("STOCK9006", "Stock is successfully added into the database"),
	SUCCESSFUL_DELETION("STOCK9007", "Stock is successfully deleted from the database");
	
	private String value;
	
	private String description;
	
	private StockMessageCode(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	

}
