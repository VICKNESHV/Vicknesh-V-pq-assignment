package com.payconiq.stocks.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payconiq.stocks.entity.Stock;

public interface StocksRepository extends JpaRepository<Stock, String>{
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Stock WHERE cusipId = :cusipId")
	Integer deleteByCusipId(@Param("cusipId") String cusipId);

}
