package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;

@Repository
public interface GeisternetzRepository extends JpaRepository<GeisternetzDataModel, Long> {
}
