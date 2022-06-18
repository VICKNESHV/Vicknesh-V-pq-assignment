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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.stocks.model.StatusMessageResponse;
import com.payconiq.stocks.model.StockRequest;
import com.payconiq.stocks.model.StockResponse;
import com.payconiq.stocks.service.StocksService;

@RestController
public class StocksController {

	@Autowired
	private StocksService stocksService;

	@PostMapping("/stocks")
	public ResponseEntity<StatusMessageResponse> createStock(@RequestBody StockRequest stockRequest) {
		return new ResponseEntity<StatusMessageResponse>(stocksService.addStock(stockRequest), HttpStatus.OK);
	}

	@GetMapping("/stocks")
	public ResponseEntity<List<StockResponse>> getStocks(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size) {
		return new ResponseEntity<List<StockResponse>>(stocksService.getStockList(page, size), HttpStatus.OK);
	}

	@GetMapping("/stocks/{cusipId}")
	public ResponseEntity<StockResponse> getStockBycusipId(@PathVariable("cusipId") String cusipId) {
		return new ResponseEntity<StockResponse>(stocksService.getStockById(cusipId), HttpStatus.OK);
	}

	@PatchMapping("/stocks/{cusipId}")
	public ResponseEntity<StatusMessageResponse> updateStockBycusipId(@PathVariable("cusipId") String cusipId,
			@Valid @RequestBody StockRequest stockRequest) {
		return new ResponseEntity<StatusMessageResponse>(stocksService.updateStock(stockRequest), HttpStatus.OK);
	}

	@DeleteMapping("/stocks/{cusipId}")
	public ResponseEntity<StatusMessageResponse> deleteStockBycusipId(@PathVariable("cusipId") String cusipiD) {
		stocksService.deleteStock(cusipiD);
		return new ResponseEntity<StatusMessageResponse>(stocksService.deleteStock(cusipiD), HttpStatus.OK);
	}

}
