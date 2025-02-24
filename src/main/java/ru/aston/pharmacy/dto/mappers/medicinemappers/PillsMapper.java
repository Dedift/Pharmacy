package ru.aston.pharmacy.dto.mappers.medicinemappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.medicine.Pills;
import ru.aston.pharmacy.dto.MedicineDTO.PillsDTO;

import java.util.List;

@Mapper(uses = MedicineMapper.class)
public interface PillsMapper {
    PillsDTO toPillsDTO(Pills pills);
    List<PillsDTO> toPillsDTOList(List<Pills> pills);
    Pills toPills(PillsDTO pillsDTO);
    List<Pills> toPillsList(List<PillsDTO> pillsDTOs);
}
