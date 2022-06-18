package com.payconiq.stocks.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="STOCKS")
public class Stock {
	
	@Id
	@Column(name = "CUSIP_ID")
	private String cusipId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TICKER")
	private String ticker;
	
	@Column(name = "CURRENT_PRICE")
	private BigDecimal currentPrice;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_TM")
    private Date lastUpdatedDateTm;

	public String getCusipId() {
		return cusipId;
	}

	public void setCusipId(String cusipId) {
		this.cusipId = cusipId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getLastUpdatedDateTm() {
		return lastUpdatedDateTm;
	}

	public void setLastUpdatedDateTm(Date lastUpdatedDateTm) {
		this.lastUpdatedDateTm = lastUpdatedDateTm;
	}

}
