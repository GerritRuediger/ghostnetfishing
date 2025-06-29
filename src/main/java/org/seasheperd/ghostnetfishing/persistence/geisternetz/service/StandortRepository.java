package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.StandortDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandortRepository extends JpaRepository<StandortDataModel, Long> {
    Optional<StandortDataModel> findByBreitengradAndLaengengrad(double breitengrad, double laengengrad);
}
