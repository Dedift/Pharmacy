package ru.aston.pharmacy.repository.clientrepositories;

import ru.aston.pharmacy.domain.client.Review;
import ru.aston.pharmacy.domain.client.User;
import ru.aston.pharmacy.repository.BaseRepository;

import java.util.Optional;

public interface ReviewRepository extends BaseRepository<Review, Integer> {
    Optional<Review> findByUser(User user);
}
