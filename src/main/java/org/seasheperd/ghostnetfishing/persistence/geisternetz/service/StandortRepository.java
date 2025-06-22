package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.StandortDataModel;

@Repository
public interface StandortRepository extends JpaRepository<StandortDataModel, Long> {
}
