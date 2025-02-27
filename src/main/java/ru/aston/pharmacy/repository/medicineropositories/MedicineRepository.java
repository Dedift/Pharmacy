package ru.aston.pharmacy.repository.medicineropositories;

import ru.aston.pharmacy.domain.medicine.Medicine;
import ru.aston.pharmacy.repository.BaseRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MedicineRepository extends BaseRepository<Medicine, Integer> {
    List<Medicine> findByName(String name);

    List<Medicine> findByActiveSubstance(String activeSubstance);

    List<Medicine> findByPriceBetween(BigDecimal priceAfter, BigDecimal priceBefore);

    List<Medicine> findByNeedRecipe(Boolean needRecipe);
}