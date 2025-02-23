package ru.aston.pharmacy.domain.client;

import jakarta.persistence.*;
import lombok.*;
import ru.aston.pharmacy.domain.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(schema = "gym_schema")
public class Review extends BaseEntity<Integer> {

    private String text;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;
}