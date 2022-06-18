package com.payconiq.stocks.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.payconiq.stocks.constants.StockMessageCode;
import com.payconiq.stocks.dao.StocksDAO;
import com.payconiq.stocks.entity.Stock;
import com.payconiq.stocks.exception.NoDataFoundException;
import com.payconiq.stocks.exception.StockException;
import com.payconiq.stocks.mapper.StockMapper;
import com.payconiq.stocks.model.StatusMessageResponse;
import com.payconiq.stocks.model.StockRequest;
import com.payconiq.stocks.model.StockResponse;

@Service
@Transactional
public class StocksService {

	@Autowired
	private StockMapper stockMapper;

	@Autowired
	private StocksDAO stocksDAO;

	public List<StockResponse> getStockList(int page, int size) {
		List<Stock> stockList = stocksDAO.getStockList(PageRequest.of(page, size)).getContent();
		if (!CollectionUtils.isEmpty(stockList)) {
			return stockMapper.getStockResponseList(stockList);
		} else {
			throw new NoDataFoundException("No data matches the search criteria", StockMessageCode.NO_DATA_FOUND);
		}
	}

	public StockResponse getStockById(String cusipId) {
		Stock stock = stocksDAO.getStockByCusipId(cusipId);
		if (stock != null) {
			return stockMapper.getStockResponse(stock);
		} else {
			throw new NoDataFoundException("No data matches the search criteria", StockMessageCode.NO_DATA_FOUND);
		}
	}

	public StatusMessageResponse addStock(StockRequest stockRequest) {
		Stock stock = new Stock();
		stock.setCurrentPrice(stockRequest.getCurrentPrice());
		stock.setCusipId(stockRequest.getCusipId());
		stock.setName(stockRequest.getName());
		stock.setLastUpdatedDateTm(new Date());
		stocksDAO.saveStock(stock);
		return stockMapper.createSuccessfulResponse(StockMessageCode.SUCCESSFUL_ADDITION.getValue());
	}

	public StatusMessageResponse updateStock(StockRequest stockRequest) {
		Stock stock = null;
		try {
			stock = stocksDAO.getStockByCusipId(stockRequest.getCusipId());
			if (stock != null) {
				stock.setCusipId(stockRequest.getCusipId());
				stock.setName(stockRequest.getName());
				stock.setCurrentPrice(stockRequest.getCurrentPrice());
				stock.setLastUpdatedDateTm(new Date());
				stocksDAO.saveStock(stock);
			} else {
				throw new NoDataFoundException("No data matches the search criteria", StockMessageCode.NO_DATA_FOUND);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new NoDataFoundException("No data matches the search criteria", StockMessageCode.NO_DATA_FOUND);
		}

		return stockMapper.createSuccessfulResponse(StockMessageCode.SUCCESSFUL_UPDATION.getValue());
	}

	public StatusMessageResponse deleteStock(String cusipId) {
		try {
			stocksDAO.deleteStockById(cusipId);
		} catch (EmptyResultDataAccessException e) {
			throw new NoDataFoundException("No data matches the search criteria", StockMessageCode.NO_DATA_FOUND);
		} catch (Exception e) {
			throw new StockException("Exception occured while deleting the stock", StockMessageCode.INTERNAL_ERROR);
		}
		return stockMapper.createSuccessfulResponse(StockMessageCode.SUCCESSFUL_DELETION.getValue());
	}

}
