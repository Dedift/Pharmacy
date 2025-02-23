package ru.aston.pharmacy.domain.medicine;

import jakarta.persistence.Entity;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a powder medicine, which is a specific type of medicine.
 * Inherits from the abstract class Medicine and adds a numberSachetsInPackage field.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Powder extends Medicine{

    private static final Logger log = LoggerFactory.getLogger(Powder.class);
    private Integer numberSachetsInPackage;
}
