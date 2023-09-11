package com.ciee.application.services;

import com.ciee.domain.dto.Metadata;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@Data
public abstract class BaseService<Entity extends Metadata, Dto extends Metadata> {

    private ModelMapper mapper;

    protected final Dto entityToDto(final Entity entity, final Class<Dto> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    protected final Entity dtoToEntity(final Dto dto, final Class<Entity> entityClass) {
        return mapper.map(dto, entityClass);
    }

}