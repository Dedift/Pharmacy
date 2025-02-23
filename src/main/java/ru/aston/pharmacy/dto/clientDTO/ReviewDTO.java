package ru.aston.pharmacy.dto.clientDTO;

import ru.aston.pharmacy.dto.BaseDTO;

public record ReviewDTO (BaseDTO baseDTO, String text, UserDTO user) {
}
