package ru.aston.pharmacy.dto.clientDTO;

import ru.aston.pharmacy.dto.BaseDTO;
import ru.aston.pharmacy.dto.MedicineDTO.MedicineDTO;

public record RecipeDTO(BaseDTO baseDTO, MedicineDTO medicine, UserDTO user) {
}
