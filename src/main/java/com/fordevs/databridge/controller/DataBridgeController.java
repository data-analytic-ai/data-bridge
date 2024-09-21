package com.fordevs.databridge.controller;

import com.fordevs.databridge.dto.QueryRequest;
import com.fordevs.databridge.service.QueryBridgeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/test")
public class DataBridgeController {

    private final QueryBridgeClient queryBridgeClient;

    public DataBridgeController(QueryBridgeClient queryBridgeClient) {
        this.queryBridgeClient = queryBridgeClient;
    }

    @PostMapping("/query")
    public String testQuery(@RequestBody QueryRequest request) {
        log.info("Received request to generate query: {}", request);
        return queryBridgeClient.getDynamicQuery(request);
    }
}
