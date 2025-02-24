package ru.aston.pharmacy.dto.mappers.medicinemappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.medicine.Drops;
import ru.aston.pharmacy.dto.MedicineDTO.DropsDTO;

import java.util.List;

@Mapper(uses = MedicineMapper.class)
public interface DropsMapper {
    DropsDTO toDropsDTO(Drops drops);
    List<DropsDTO> toDropsDTOList(List<Drops> drops);
    Drops toDrops(DropsDTO dropsDTO);
    List<Drops> toDropsList(List<DropsDTO> dropsDTOS);
}
