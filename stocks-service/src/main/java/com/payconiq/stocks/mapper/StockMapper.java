package com.payconiq.stocks.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.payconiq.stocks.constants.StockMessageCode;
import com.payconiq.stocks.entity.Stock;
import com.payconiq.stocks.model.StatusMessage;
import com.payconiq.stocks.model.StatusMessage.TypeEnum;
import com.payconiq.stocks.model.StatusMessageResponse;
import com.payconiq.stocks.model.StockResponse;

@Component
public class StockMapper {

	public StatusMessageResponse createSuccessfulResponse(String type) {
		StatusMessageResponse response = new StatusMessageResponse();
		List<StatusMessage> statusMessageList = new ArrayList<>();
		StatusMessage statusMessage = new StatusMessage();
		if (type.equalsIgnoreCase(StockMessageCode.SUCCESSFUL_ADDITION.getValue())) {
			statusMessage.setMessage(StockMessageCode.SUCCESSFUL_ADDITION.getDescription());
			statusMessage.setCode(StockMessageCode.SUCCESSFUL_ADDITION.getValue());
		} else if (type.equalsIgnoreCase(StockMessageCode.SUCCESSFUL_UPDATION.getValue())) {
			statusMessage.setMessage(StockMessageCode.SUCCESSFUL_UPDATION.getDescription());
			statusMessage.setCode(StockMessageCode.SUCCESSFUL_UPDATION.getValue());
		} else if (type.equalsIgnoreCase(StockMessageCode.SUCCESSFUL_DELETION.getValue())) {
			statusMessage.setMessage(StockMessageCode.SUCCESSFUL_DELETION.getDescription());
			statusMessage.setCode(StockMessageCode.SUCCESSFUL_DELETION.getValue());
		}
		statusMessage.setType(TypeEnum.SUCCESS);
		statusMessageList.add(statusMessage);
		response.setStatusMessages(statusMessageList);
		return response;
	}

	public List<StockResponse> getStockResponseList(List<Stock> stockList) {
		List<StockResponse> stockResponseList = stockList.stream().map(s -> {
			StockResponse stockResponse = new StockResponse();
			stockResponse.setCusipId(s.getCusipId());
			stockResponse.setName(s.getName());
			stockResponse.setTicker(s.getTicker());
			stockResponse.setCurrentPrice(s.getCurrentPrice());
			stockResponse.setLastUpdatedDtTm(
					s.getLastUpdatedDateTm() != null ? s.getLastUpdatedDateTm().toString()
							: null);
			return stockResponse;
		}).collect(Collectors.toList());
		return stockResponseList;
	}

	public StockResponse getStockResponse(Stock stock) {
		StockResponse stockResponse = new StockResponse();
		stockResponse.setCusipId(stock.getCusipId());
		stockResponse.setName(stock.getName());
		stockResponse.setTicker(stock.getTicker());
		stockResponse.setCurrentPrice(stock.getCurrentPrice());
		stockResponse.setLastUpdatedDtTm(
				stock.getLastUpdatedDateTm() != null ? stock.getLastUpdatedDateTm().toString()
						: null);
		return stockResponse;
	}
}
