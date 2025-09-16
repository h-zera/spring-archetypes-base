package com.hzera.archetypes.base.archetype.application.ports.driver;

import com.hzera.archetypes.base.archetype.application.exceptions.ExampleNotFoundException;
import com.hzera.archetypes.base.archetype.common.domain.HZeraPage;
import com.hzera.archetypes.base.archetype.domain.entity.ExampleEntity;

import java.util.Optional;

public interface ExampleServicePort {

    HZeraPage<ExampleEntity> getAllExamples(Integer pageNumber, Integer pageSize, String sort);

    Optional<ExampleEntity> getExample(Long id) throws ExampleNotFoundException;

    ExampleEntity createExample(ExampleEntity example);

    ExampleEntity updateExample(Long id, ExampleEntity exampleUpdate);

    void deleteExample(Long id);

}
