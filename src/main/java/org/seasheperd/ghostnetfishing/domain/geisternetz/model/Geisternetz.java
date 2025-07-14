package org.seasheperd.ghostnetfishing.domain.geisternetz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Geisternetz {
    private long id;
    private Standort standort;
    private Groesse groesse;
    private Status status;
    private Long userId;

    public Geisternetz(Standort standort, Groesse groesse) {
        this.standort = standort;
        this.groesse = groesse;
        this.id = 0;
        this.status = Status.GEMELDET;
    }
}
