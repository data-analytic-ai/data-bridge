package com.fordevs.databridge.service;

import com.fordevs.databridge.dto.DatabaseConnectionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueryBridgeDatabaseClient {

    private final RestTemplate restTemplate;

    @Value("${query.bridge.url}")
    private String queryBridgeUrl;

    public QueryBridgeDatabaseClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void connectToDatabase(DatabaseConnectionRequest request) {
        log.info("Connecting to database: {} on host: {}", request.getDatabaseName(), request.getHost());
        restTemplate.postForEntity(queryBridgeUrl + "/database/connect", request, Void.class);
        log.info("Database connection established successfully");
    }
}
