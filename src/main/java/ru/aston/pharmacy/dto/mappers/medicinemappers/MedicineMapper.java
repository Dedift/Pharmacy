package ru.aston.pharmacy.dto.mappers.medicinemappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.medicine.Medicine;
import ru.aston.pharmacy.dto.MedicineDTO.MedicineDTO;
import ru.aston.pharmacy.dto.mappers.BaseMapper;

import java.util.List;

@Mapper(uses = BaseMapper.class)
public interface MedicineMapper {
    MedicineDTO toMedicineDTO(Medicine medicine);
    List<MedicineDTO> toMedicineDTOList(List<Medicine> medicines);
    Medicine toMedicine(MedicineDTO medicineDTO);
    List<Medicine> toMedicineList(List<MedicineDTO> medicineDTOs);
}
