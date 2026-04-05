package com.ymweatherapp.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymweatherapp.demo.model.StationRainfallDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RainfallService {
  private final String API_URL = "https://api-open.data.gov.sg/v2/real-time/api/rainfall";

  public List<StationRainfallDTO> getRainfallData() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject(API_URL, String.class);

    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(response);

    List<StationRainfallDTO> result = new ArrayList<>();

    JsonNode stations = root.path("data").path("stations");
    JsonNode readings = root.path("data").path("readings");

    Map<String, Integer> rainfallMap = new HashMap<>();

    if (readings.isArray() && readings.size() > 0) {
      JsonNode dataArray = readings.path("data");

      for (JsonNode r : dataArray) {
        String stationId = r.path("stationId").asText();
        int value = r.path("value").asInt();

        rainfallMap.put(stationId, value);
      }
    }

    for (JsonNode r : stations) {
      String stationId = r.path("id").asText();
      String name = r.path("name").asText();

      int rainfallMm = rainfallMap.getOrDefault(stationId, 0);

      result.add(new StationRainfallDTO(stationId, name, rainfallMm));
    }

    return result;
  }
}
