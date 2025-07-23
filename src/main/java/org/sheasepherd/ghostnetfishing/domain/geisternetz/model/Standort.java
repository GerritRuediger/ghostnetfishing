package org.sheasepherd.ghostnetfishing.domain.geisternetz.model;

import lombok.Value;

@Value
public class Standort {
    long id;
    double breitengrad;
    double laengengrad;
}
