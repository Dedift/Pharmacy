package ru.aston.pharmacy.dto.mappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.dto.BaseDTO;

import java.util.List;

@Mapper
public interface BaseMapper {
    BaseDTO toBaseDTO(BaseDTO baseDTO);
    List<BaseDTO> toBaseDTOList(List<BaseDTO> baseDTOs);
}
