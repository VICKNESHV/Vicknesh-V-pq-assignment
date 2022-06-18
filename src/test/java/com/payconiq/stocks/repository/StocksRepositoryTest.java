package com.payconiq.stocks.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.payconiq.stocks.entity.Stock;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StocksRepositoryTest {

	@Autowired
	private StocksRepository stocksRepository;

	// JUnit test for saveEmployee
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveStockTest() {
		Stock stock = new Stock();
		stock.setCusipId("02079K305");
		stock.setName("Alphabet Inc");
		stock.setTicker("GOOG");
		stocksRepository.save(stock);
		Assertions.assertThat(stock.getCusipId()).isNotNull();
	}

	@Test
	@Order(2)
	public void getEmployeeTest() {
		Stock stock = stocksRepository.findById("02079K305").get();
		Assertions.assertThat(stock.getCusipId()).isEqualTo("02079K305");
	}

	@Test
	@Order(3)
	public void getListOfStocksTest() {
		List<Stock> stockList = stocksRepository.findAll();
		Assertions.assertThat(stockList.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateStockTest() {
		Stock stock = stocksRepository.findById("02079K305").get();
		stock.setCurrentPrice(new BigDecimal(100.00));
		Stock stockUpdated = stocksRepository.save(stock);
		Assertions.assertThat(stockUpdated.getCurrentPrice()).isEqualTo(new BigDecimal(100.00));
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteStockTest() {
		Stock stock = stocksRepository.findById("02079K305").get();
		stocksRepository.delete(stock);
		Stock stock1 = null;
		Optional<Stock> optionalStock = stocksRepository.findById("02079K305");
		if (optionalStock.isPresent()) {
			stock1 = optionalStock.get();
		}
		Assertions.assertThat(stock1).isNull();
	}

}