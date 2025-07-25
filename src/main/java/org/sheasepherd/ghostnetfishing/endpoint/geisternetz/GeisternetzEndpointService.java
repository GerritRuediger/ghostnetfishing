package org.sheasepherd.ghostnetfishing.endpoint.geisternetz;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.api.GeisternetzService;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeisternetzEndpointService {
    private final GeisternetzEndpointMapper mapper;
    private final GeisternetzService service;

    public void submitNewGeisternetz(StandortEndpointModel standort, Groesse groesse) {
        service.createGeisternetz(mapper.toStandort(standort), groesse);
    }

    public void updateGeisternetzStatus(long id, Status newStatus) {
        service.updateStatus(id, newStatus);
    }

    public void updateGeisternetzUserId(long id, long newUserId) {
        service.updateUserId(id, newUserId);
    }

    public List<GeisternetzEndpointModel> findAllZuBergendeGeisternetze() {
        return service.findAllGemeldetGeisternetze().stream().map(mapper::toGeisternetzEndpointModel).toList();
    }

    public GeisternetzEndpointModel findById(long id) {
        return service.findById(id).map(mapper::toGeisternetzEndpointModel).orElse(null);
    }

    public List<GeisternetzEndpointModel> findAllGeisternetzeByUserId(long userId) {
        return service.findAllGeisternetzeByUserId(userId).stream().map(mapper::toGeisternetzEndpointModel).toList();
    }
}
