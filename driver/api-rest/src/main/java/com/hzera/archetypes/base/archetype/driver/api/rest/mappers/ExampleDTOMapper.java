package com.hzera.archetypes.base.archetype.driver.api.rest.mappers;

import com.hzera.archetypes.base.archetype.common.domain.HZeraPage;
import com.hzera.archetypes.base.archetype.common.rest.api.builder.HZeraPageResponseUtil;
import com.hzera.archetypes.base.archetype.domain.entity.ExampleEntity;
import com.hzera.archetypes.base.archetype.driver.api.rest.openapi.model.*;
import com.hzera.archetypes.base.archetype.driver.api.rest.openapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = { HZeraPageResponseUtil.class })
public abstract class ExampleDTOMapper {

    @Autowired
    private HZeraPageResponseUtil HZeraPageResponseUtil;

    static final ExampleDTOMapper INSTANCE = Mappers.getMapper(ExampleDTOMapper.class);

    @Mapping(target = "id", ignore = true)
    public abstract ExampleEntity from(ExampleRequest request);

    public abstract ExampleResource to(ExampleEntity entity);

    public ExampleResourceCollectionResponse toExampleResourceCollectionResponse(HZeraPage<ExampleEntity> examples) {

        var pagination = Pagination
                .builder()
                .requestedPage(examples.getNumber())
                .requestedSize(examples.getSize())
                .retrievedResults(examples.getNumberOfElements())
                .totalResults(examples.getTotalElements())
                .nextPage(HZeraPageResponseUtil.buildNextPage(examples))
                .previousPage(HZeraPageResponseUtil.buildPreviousPage(examples))
                .build();

        var exampleResourceCollection = getExampleResourceCollection(examples);
        return ExampleResourceCollectionResponse
                .builder()
                .data(exampleResourceCollection)
                .pagination(pagination)
                .build();
    }

    public ExampleResourceCollection getExampleResourceCollection(HZeraPage<ExampleEntity> examples) {
        return ExampleResourceCollection.builder()
                .examples(listExampleEntityToResource(examples.getContent()))
                .build();
    }

    public ExampleResourceResponse toResponse(ExampleEntity entity) {
        return ExampleResourceResponse.builder().data(INSTANCE.to(entity)).build();
    }

    public abstract List<ExampleResource> listExampleEntityToResource(List<ExampleEntity> list);
}
