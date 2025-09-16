package com.hzera.archetypes.base.archetype.driven.postgres;

import com.hzera.archetypes.base.archetype.driven.postgres.models.ExampleMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleMOJpaRepository extends JpaRepository<ExampleMO, Long> {
}
