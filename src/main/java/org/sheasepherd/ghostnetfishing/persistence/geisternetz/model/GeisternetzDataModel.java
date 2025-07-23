package org.sheasepherd.ghostnetfishing.persistence.geisternetz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geisternetz")
public class GeisternetzDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private StandortDataModel standort;

    @Enumerated(EnumType.STRING)
    private Groesse groesse;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long userId;
}
