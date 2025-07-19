package org.seasheperd.ghostnetfishing.persistence.geisternetz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "standort",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_standort_koordinaten",
                columnNames = {"breitengrad", "laengengrad"}
        )
)
public class StandortDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double breitengrad;
    double laengengrad;
}
