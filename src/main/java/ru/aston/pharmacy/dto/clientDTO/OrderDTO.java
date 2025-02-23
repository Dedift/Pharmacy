package ru.aston.pharmacy.dto.clientDTO;

import ru.aston.pharmacy.dto.BaseDTO;
import ru.aston.pharmacy.dto.MedicineDTO.MedicineDTO;

import java.util.List;

public record OrderDTO(BaseDTO baseDTO, List<MedicineDTO> medicines, UserDTO user) {
}
