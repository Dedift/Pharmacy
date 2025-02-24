package ru.aston.pharmacy.dto.mappers.medicinemappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.medicine.Powder;
import ru.aston.pharmacy.dto.MedicineDTO.PowderDTO;

import java.util.List;

@Mapper(uses = MedicineMapper.class)
public interface PowderMapper {
    PowderDTO toPowderDTO(Powder powder);
    List<PowderDTO> toPowderDTOList(List<Powder> powders);
    Powder toPowder(PowderDTO powderDTO);
    List<Powder> toPowderList(List<PowderDTO> powderDTOs);
}
