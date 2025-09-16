package com.hzera.archetypes.base.archetype.application.ports.driven;

import com.hzera.archetypes.base.archetype.common.interfaces.SNACrudRepository;
import com.hzera.archetypes.base.archetype.domain.entity.ExampleEntity;

public interface ExampleRepositoryPort extends SNACrudRepository<ExampleEntity, Long> {
}
