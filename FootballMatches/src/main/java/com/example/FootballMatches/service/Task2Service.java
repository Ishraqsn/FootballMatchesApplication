package com.example.FootballMatches.service;

import com.example.FootballMatches.util.ResponseDelayUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Task2Service {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResponseDelayUtil responseDelayUtil;

    public int getDrawnMatchesCount(int year) {
        String apiUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=1";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode dataNode = rootNode.get("data");
            int drawnMatchesCount = 0;
            for (JsonNode matchNode : dataNode) {
                int team1Goals = matchNode.get("team1goals").asInt();
                int team2Goals = matchNode.get("team2goals").asInt();
                if (team1Goals == team2Goals) {
                    drawnMatchesCount++;
                }
            }
            return drawnMatchesCount;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Async
    public int fetchData(int year) {
        responseDelayUtil.delayResponse();
        return getDrawnMatchesCount(year);
    }
}
