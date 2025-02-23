package ru.aston.pharmacy.domain.client;

import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.pharmacy.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a user in the system.
 * Contains personal information, financial details, and methods for managing orders and prescriptions.
 */
@Setter
@Getter
@ToString(exclude = {"order", "recipes"})
@EqualsAndHashCode(exclude = {"order", "recipes"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "pharmacy_schema", name = "users")
public class User extends BaseEntity<Integer> {

    private static final Logger log = LoggerFactory.getLogger(User.class);
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Review review;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Recipe> recipes;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> order;
    private String name;
    private String surName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal money;
}