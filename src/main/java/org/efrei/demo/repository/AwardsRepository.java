package org.efrei.demo.repository;

import org.efrei.demo.models.Awards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardsRepository extends JpaRepository<Awards, String> {

}