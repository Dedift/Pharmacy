package ru.aston.pharmacy.dto.mappers.medicinemappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.medicine.Cream;
import ru.aston.pharmacy.dto.MedicineDTO.CreamDTO;

import java.util.List;

@Mapper(uses = MedicineMapper.class)
public interface CreamMapper {
    CreamDTO toCreamDTO(Cream cream);
    List<CreamDTO> toCreamDTOList(List<Cream> creams);
}
