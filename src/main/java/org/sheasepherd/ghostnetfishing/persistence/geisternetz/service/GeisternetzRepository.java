package org.sheasepherd.ghostnetfishing.persistence.geisternetz.service;

import org.sheasepherd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeisternetzRepository extends JpaRepository<GeisternetzDataModel, Long> {
}
