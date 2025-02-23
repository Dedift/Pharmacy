package ru.aston.pharmacy.domain.medicine;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.pharmacy.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * Abstract class representing a generic medicine.
 * This class serves as the base for specific types of medicines and provides common properties
 * such as name, price, prescription requirement, and active substance.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "pharmacy_schema")
public abstract class Medicine extends BaseEntity<Integer> {

    protected static final Logger log = LoggerFactory.getLogger(Medicine.class);
    protected String name;
    protected BigDecimal price;
    protected Boolean needRecipe;
    protected String activeSubstance;
}