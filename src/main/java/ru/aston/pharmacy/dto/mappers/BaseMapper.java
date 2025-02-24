package ru.aston.pharmacy.dto.mappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.BaseEntity;
import ru.aston.pharmacy.dto.BaseDTO;

import java.util.List;

@Mapper
public interface BaseMapper {
    BaseDTO toBaseDTO(BaseEntity<Integer> baseEntity);
    List<BaseDTO> toBaseDTOList(List<BaseEntity> baseEntities);
    BaseEntity<Integer> toBaseEntity(BaseDTO baseDTO);
    List<BaseEntity> toBaseEntityList(List<BaseDTO> baseDTOs);

}
