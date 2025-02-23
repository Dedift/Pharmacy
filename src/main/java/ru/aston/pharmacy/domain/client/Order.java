package ru.aston.pharmacy.domain.client;

import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.pharmacy.domain.BaseEntity;
import ru.aston.pharmacy.exceptions.ExceptionHandler;
import ru.aston.pharmacy.exceptions.NullValueException;
import ru.aston.pharmacy.domain.medicine.Medicine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Represents an order made by a user.
 * Contains a list of medicines and the user who placed the order.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "pharmacy_schema", name = "orders")
public class Order extends BaseEntity<Integer> {

    private static final Logger log = LoggerFactory.getLogger(Order.class);
    @OneToMany(fetch = FetchType.LAZY)
    private List<Medicine> medicines;
    @Setter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Calculates the total price of all medicines in the order.
     *
     * @return The total price of the medicines in the order.
     */
    public BigDecimal getPriceOfMedicines() {
        try {
            if (Objects.isNull(medicines)) {
                throw new NullValueException("Medicines list is null");
            }

            BigDecimal sum = medicines.stream()
                    .map(Medicine::getPrice)
                    .peek(price -> log.debug("Processing medicine with price: {}", price))
                    .reduce(BigDecimal::add)
                    .orElseThrow(() -> new NullValueException("Price is null"));

            log.debug("Calculated total price of medicines in order: {}", sum);
            return sum;

        } catch (Exception exception) {
            log.debug("Medicines list or price is null, returning 0.0");
            ExceptionHandler.handleException(exception);
            return BigDecimal.ZERO;
        }
    }
}