package com.fordevs.databridge.controller;

import com.fordevs.databridge.dto.DatabaseConnectionRequest;
import com.fordevs.databridge.service.QueryBridgeDatabaseClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data/bridge")
@Slf4j
public class DatabaseConnectionController {

    private final QueryBridgeDatabaseClient queryBridgeDatabaseClient;

    public DatabaseConnectionController(QueryBridgeDatabaseClient queryBridgeDatabaseClient) {
        this.queryBridgeDatabaseClient = queryBridgeDatabaseClient;
    }

    @PostMapping("/database/connect")
    public String connectToDatabase(@RequestBody DatabaseConnectionRequest request) {
        queryBridgeDatabaseClient.connectToDatabase(request);
        return "Connection Successful!";
    }
}
