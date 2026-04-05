package com.ymweatherapp.demo.controller;

import com.ymweatherapp.demo.model.StationRainfallDTO;
import com.ymweatherapp.demo.service.RainfallService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rainfall")
public class RainfallController {
  @Autowired private RainfallService rainfallService;

  @GetMapping("/all")
  public List<StationRainfallDTO> getAllRainfall() throws Exception {
    return rainfallService.getRainfallData();
  }
}
