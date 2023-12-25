package com.elkastali.voitureservice.repository;

import com.elkastali.voitureservice.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
