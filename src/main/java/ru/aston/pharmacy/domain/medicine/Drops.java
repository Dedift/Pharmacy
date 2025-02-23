package ru.aston.pharmacy.domain.medicine;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a drops medicine, which is a specific type of medicine.
 * Inherits from the abstract class Medicine and adds a volume field.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Drops extends Medicine {

    private Integer volume;
}