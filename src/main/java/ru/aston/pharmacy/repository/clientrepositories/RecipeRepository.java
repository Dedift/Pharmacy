package ru.aston.pharmacy.repository.clientrepositories;

import ru.aston.pharmacy.domain.client.Recipe;
import ru.aston.pharmacy.domain.client.User;
import ru.aston.pharmacy.domain.medicine.Medicine;
import ru.aston.pharmacy.repository.BaseRepository;

import java.util.Optional;

public interface RecipeRepository  extends BaseRepository<Recipe, Integer> {
    Optional<Recipe> findByMedicine(Medicine medicine);
    Optional<Recipe> findByUser(User user);
}
