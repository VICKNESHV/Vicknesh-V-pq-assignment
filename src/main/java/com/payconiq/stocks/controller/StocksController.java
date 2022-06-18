package com.payconiq.stocks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.stocks.model.StatusMessageResponse;
import com.payconiq.stocks.model.StockRequest;
import com.payconiq.stocks.model.StockResponse;
import com.payconiq.stocks.service.StocksService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StocksController {

	@Autowired
	private StocksService stocksService;

	@ApiOperation(value = "Add a stock to the inventory", nickname = "createStock", notes = "Add a stock to the inventory", response = StatusMessageResponse.class, tags={ "stocks"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = StatusMessageResponse.class),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
	@PostMapping("/stocks")
	public ResponseEntity<StatusMessageResponse> createStock(@RequestBody StockRequest stockRequest) {
		return new ResponseEntity<StatusMessageResponse>(stocksService.addStock(stockRequest), HttpStatus.OK);
	}

	@ApiOperation(value = "Returns stocks from the inventories", nickname = "getStocks", notes = "Returns the list of stocks", response = StockResponse.class, responseContainer = "List", tags={ "stocks"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The service request was processed successfully.", response = StockResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
	@GetMapping("/stocks")
	public ResponseEntity<List<StockResponse>> getStocks(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size) {
		return new ResponseEntity<List<StockResponse>>(stocksService.getStockList(page, size), HttpStatus.OK);
	}

	@ApiOperation(value = "Find stock by cusipID", nickname = "getStockBycusipId", notes = "Returns a stock", response = StockResponse.class, tags={ "stocks"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The service request was processed successfully.", response = StockResponse.class),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
	@GetMapping("/stocks/{cusipId}")
	public ResponseEntity<StockResponse> getStockBycusipId(@PathVariable("cusipId") String cusipId) {
		return new ResponseEntity<StockResponse>(stocksService.getStockById(cusipId), HttpStatus.OK);
	}

	@ApiOperation(value = "Update stock by cusipID", nickname = "updateStockBycusipId", notes = "Update a stock", response = StatusMessageResponse.class, tags={ "stocks"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The service request was processed successfully.", response = StatusMessageResponse.class),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
    @RequestMapping(value = "/stocks/{cusipiD}",
        produces = { "application/json" }, 
        method = RequestMethod.PATCH)
	@PatchMapping("/stocks/{cusipId}")
	public ResponseEntity<StatusMessageResponse> updateStockBycusipId(@PathVariable("cusipId") String cusipId,
			@Valid @RequestBody StockRequest stockRequest) {
		return new ResponseEntity<StatusMessageResponse>(stocksService.updateStock(stockRequest), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a stock by cusipID", nickname = "deleteStockBycusipId", notes = "Delete a stock", response = StatusMessageResponse.class, tags={ "stocks"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The service request was processed successfully.", response = StatusMessageResponse.class),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
	@DeleteMapping("/stocks/{cusipId}")
	public ResponseEntity<StatusMessageResponse> deleteStockBycusipId(@PathVariable("cusipId") String cusipiD) {
		stocksService.deleteStock(cusipiD);
		return new ResponseEntity<StatusMessageResponse>(stocksService.deleteStock(cusipiD), HttpStatus.OK);
	}

}
