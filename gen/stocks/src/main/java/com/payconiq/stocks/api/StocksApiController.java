package com.payconiq.stocks.api;

import com.payconiq.stocks.model.StatusMessageResponse;
import com.payconiq.stocks.model.StockRequest;
import com.payconiq.stocks.model.StockResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-17T22:47:13.145+05:30")

@Controller
public class StocksApiController implements StocksApi {

    private static final Logger log = LoggerFactory.getLogger(StocksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StocksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<StatusMessageResponse> createStock(@ApiParam(value = "Request to add a stock to the inventory" ,required=true )  @Valid @RequestBody StockRequest stock) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StatusMessageResponse>(objectMapper.readValue("{\"empty\": false}", StatusMessageResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StatusMessageResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StatusMessageResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StatusMessageResponse> deleteStockBycusipId(@ApiParam(value = "cusipId of the stock",required=true) @PathVariable("cusipiD") String cusipiD) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StatusMessageResponse>(objectMapper.readValue("{\"empty\": false}", StatusMessageResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StatusMessageResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StatusMessageResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StockResponse> getStockBycusipId(@ApiParam(value = "cusipId of the stock",required=true) @PathVariable("cusipiD") String cusipiD) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StockResponse>(objectMapper.readValue("{\"empty\": false}", StockResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StockResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StockResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<StockResponse>> getStocks() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<StockResponse>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<StockResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<StockResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StatusMessageResponse> updateStockBycusipId(@ApiParam(value = "cusipId of the stock",required=true) @PathVariable("cusipiD") String cusipiD,@ApiParam(value = "Request to add a stock to the inventory" ,required=true )  @Valid @RequestBody StockRequest stock) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StatusMessageResponse>(objectMapper.readValue("{\"empty\": false}", StatusMessageResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StatusMessageResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StatusMessageResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
