package com.payconiq.stocks.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StockResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-17T22:47:13.145+05:30")


public class StockResponse   {
  @JsonProperty("cusipId")
  private String cusipId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ticker")
  private String ticker = null;

  @JsonProperty("currentPrice")
  private BigDecimal currentPrice = null;

  @JsonProperty("lastUpdatedDtTm")
  private String lastUpdatedDtTm = null;

  public StockResponse cusipId(String cusipId) {
    this.cusipId = cusipId;
    return this;
  }

  /**
   * Unique identifier of stock
   * @return cusipId
  **/
  @ApiModelProperty(value = "Unique identifier of stock")


  public String getCusipId() {
    return cusipId;
  }

  public void setCusipId(String cusipId) {
    this.cusipId = cusipId;
  }

  public StockResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the stock
   * @return name
  **/
  @ApiModelProperty(value = "Name of the stock")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StockResponse ticker(String ticker) {
    this.ticker = ticker;
    return this;
  }

  /**
   * Name of the stock
   * @return ticker
  **/
  @ApiModelProperty(value = "Name of the stock")


  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public StockResponse currentPrice(BigDecimal currentPrice) {
    this.currentPrice = currentPrice;
    return this;
  }

  /**
   * Price of the stock
   * @return currentPrice
  **/
  @ApiModelProperty(value = "Price of the stock")

  @Valid

  public BigDecimal getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(BigDecimal currentPrice) {
    this.currentPrice = currentPrice;
  }

  public StockResponse lastUpdatedDtTm(String lastUpdatedDtTm) {
    this.lastUpdatedDtTm = lastUpdatedDtTm;
    return this;
  }

  /**
   * Last updated date and time of the stock
   * @return lastUpdatedDtTm
  **/
  @ApiModelProperty(value = "Last updated date and time of the stock")


  public String getLastUpdatedDtTm() {
    return lastUpdatedDtTm;
  }

  public void setLastUpdatedDtTm(String lastUpdatedDtTm) {
    this.lastUpdatedDtTm = lastUpdatedDtTm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockResponse stockResponse = (StockResponse) o;
    return Objects.equals(this.cusipId, stockResponse.cusipId) &&
        Objects.equals(this.name, stockResponse.name) &&
        Objects.equals(this.ticker, stockResponse.ticker) &&
        Objects.equals(this.currentPrice, stockResponse.currentPrice) &&
        Objects.equals(this.lastUpdatedDtTm, stockResponse.lastUpdatedDtTm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cusipId, name, ticker, currentPrice, lastUpdatedDtTm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockResponse {\n");
    
    sb.append("    cusipId: ").append(toIndentedString(cusipId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
    sb.append("    lastUpdatedDtTm: ").append(toIndentedString(lastUpdatedDtTm)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

