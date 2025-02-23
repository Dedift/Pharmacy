package ru.aston.pharmacy.dto.MedicineDTO;

import ru.aston.pharmacy.dto.BaseDTO;

import java.math.BigDecimal;

public record MedicineDTO (BaseDTO baseDTO, String name, BigDecimal price, Boolean needRecipe, String activeSubstance) {
}
