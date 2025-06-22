package org.seasheperd.ghostnetfishing.endpoint.geisternetz;

import lombok.Data;

@Data
public class StandortEndpointModel {
  long id;
  double breitengrad;
  double laengengrad;

  StandortEndpointModel() {
    this.id = 0;
  }
}
