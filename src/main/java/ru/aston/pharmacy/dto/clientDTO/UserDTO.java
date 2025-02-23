package ru.aston.pharmacy.dto.clientDTO;

import ru.aston.pharmacy.domain.client.*;
import ru.aston.pharmacy.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.List;

public record UserDTO(BaseDTO baseDTO, String email, String password,
                      Role role, ReviewDTO review, List<RecipeDTO> recipes, List<OrderDTO> orders,
                      String name, String surName, Integer age, PersonType personType,
                      Gender gender, BigDecimal money) {
}
