package com.fordevs.databridge.service;

import com.fordevs.databridge.dto.QueryRequest;
import com.fordevs.databridge.dto.QueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class QueryBridgeClient {

    private final RestTemplate restTemplate;

    @Value("${query.bridge.url}")
    private String queryBridgeUrl;

    public QueryBridgeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDynamicQuery(QueryRequest request) {
        log.info("Sending request to Query Bridge: {}", request);
        QueryResponse response = restTemplate.postForObject(
                queryBridgeUrl + "/api/generate-query", request, QueryResponse.class);
        log.info("Received dynamic query from Query Bridge: {}", response.getQuery());
        return response.getQuery();
    }
}
