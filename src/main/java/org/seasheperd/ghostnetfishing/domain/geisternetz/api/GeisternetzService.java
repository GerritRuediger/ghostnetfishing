package org.seasheperd.ghostnetfishing.domain.geisternetz.api;

import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Status;

import java.util.List;
import java.util.Optional;

public interface GeisternetzService {
    Geisternetz createGeisternetz(Standort standort, Groesse groesse);

    Geisternetz updateStatus(long id, Status newStatus);

    Geisternetz updateUserId(long id, long newUserId);

    List<Geisternetz> findAllGemeldetGeisternetze();

    Optional<Geisternetz> findById(long id);

    List<Geisternetz> findAllGeisternetzeByUserId(long userId);
}
