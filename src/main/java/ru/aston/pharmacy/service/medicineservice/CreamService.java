package ru.aston.pharmacy.service.medicineservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.dto.mappers.medicinemappers.MedicineMapper;
import ru.aston.pharmacy.repository.medicineropositories.MedicineRepository;

@Service
@Transactional(readOnly = true)
public class CreamService extends MedicineService {
    public CreamService(MedicineRepository medicineRepository, MedicineMapper medicineMapper) {
        super(medicineRepository, medicineMapper);
    }
}
