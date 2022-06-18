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
 * StockRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-18T13:03:15.216+05:30")


public class StockRequest   {
  @JsonProperty("cusipId")
  private String cusipId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ticker")
  private String ticker = null;

  @JsonProperty("currentPrice")
  private BigDecimal currentPrice = null;

  public StockRequest cusipId(String cusipId) {
    this.cusipId = cusipId;
    return this;
  }

  /**
   * Unique identifier of stock
   * @return cusipId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of stock")
  @NotNull


  public String getCusipId() {
    return cusipId;
  }

  public void setCusipId(String cusipId) {
    this.cusipId = cusipId;
  }

  public StockRequest name(String name) {
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

  public StockRequest ticker(String ticker) {
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

  public StockRequest currentPrice(BigDecimal currentPrice) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockRequest stockRequest = (StockRequest) o;
    return Objects.equals(this.cusipId, stockRequest.cusipId) &&
        Objects.equals(this.name, stockRequest.name) &&
        Objects.equals(this.ticker, stockRequest.ticker) &&
        Objects.equals(this.currentPrice, stockRequest.currentPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cusipId, name, ticker, currentPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockRequest {\n");
    
    sb.append("    cusipId: ").append(toIndentedString(cusipId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
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

