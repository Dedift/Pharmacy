package ru.aston.pharmacy.domain.client;

import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.pharmacy.domain.BaseEntity;
import ru.aston.pharmacy.domain.medicine.Medicine;

/**
 * Represents a prescription for a specific medicine issued to a user.
 * Contains the user and the medicine prescribed.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "pharmacy_schema", name = "recipes")
public class Recipe extends BaseEntity<Integer> {

    private static final Logger log = LoggerFactory.getLogger(Recipe.class);
    @Setter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    private Medicine medicine;
}