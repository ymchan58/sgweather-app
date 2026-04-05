package com.ymweatherapp.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationRainfallDTO {
  private String stationId;
  private String name;
  private int rainfallMm;
  //    private Location location;
}
