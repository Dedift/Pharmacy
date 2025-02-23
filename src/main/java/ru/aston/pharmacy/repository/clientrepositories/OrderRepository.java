package ru.aston.pharmacy.repository.clientrepositories;

import ru.aston.pharmacy.domain.client.Order;
import ru.aston.pharmacy.domain.client.User;
import ru.aston.pharmacy.domain.medicine.Medicine;
import ru.aston.pharmacy.repository.BaseRepository;

import java.util.Optional;

public interface OrderRepository extends BaseRepository<Order, Integer> {
    Optional<Order> findByUser(User user);
    Optional<Order> findByMedicine(Medicine medicine);
}
