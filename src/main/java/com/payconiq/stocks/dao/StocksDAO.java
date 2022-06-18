package com.payconiq.stocks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.payconiq.stocks.entity.Stock;
import com.payconiq.stocks.repository.StocksRepository;

@Repository
public class StocksDAO {

	@Autowired
	private StocksRepository stocksRepository;

	public Page<Stock> getStockList(PageRequest pageRequest) {
		return stocksRepository.findAll(pageRequest);
	}

	public Stock getStockByCusipId(String cusipId) {
		return stocksRepository.findById(cusipId).orElse(null);
	}

	public void saveStock(Stock stock) {
		stocksRepository.save(stock);
	}

	public boolean isStockExist(String cusipId) {
		return stocksRepository.existsById(cusipId);
	}

	public void deleteStockById(String cusipId) {
		stocksRepository.deleteByCusipId(cusipId);
	}

}
