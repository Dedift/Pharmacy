package ru.aston.pharmacy.repository.clientrepositories;

import ru.aston.pharmacy.domain.client.*;
import ru.aston.pharmacy.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);
    List<User> findByGender(Gender gender);
    Optional<User> findByReview(Review review);
    List<User> findByAge(Integer age);
    List<User> findByAgeBetween(Integer ageAfter, Integer ageBefore);
    Optional<User> findByRecipe(Recipe recipe);
    Optional<User> findByOrder(Order order);
    List<User> findByName(String name);
    List<User> findBySurName(String surName);
    List<User> findByPersonType(PersonType personType);
}