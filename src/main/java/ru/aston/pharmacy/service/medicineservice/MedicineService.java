package ru.aston.pharmacy.service.medicineservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.domain.medicine.Medicine;
import ru.aston.pharmacy.dto.MedicineDTO.MedicineDTO;
import ru.aston.pharmacy.dto.mappers.medicinemappers.MedicineMapper;
import ru.aston.pharmacy.repository.medicineropositories.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
@NoRepositoryBean
@Transactional(readOnly = true)
public abstract class MedicineService {
        private static final String DELETE_MEDICINE = "Delete medicine: {}";
        private static final String ACCEPTED_TO_DELETE_MEDICINE_DTO = "Accepted to delete medicineDTO: {}";
        private static final String UPDATE_MEDICINE = "Update medicine: {}";
        private static final String ACCEPTED_TO_UPDATE = "Accepted to update medicineDTO: {}";
        private static final String FIND_MEDICINE_BY_ID = "Find medicine: {} by id: {}";
        private static final String FIND_ALL_MEDICINES = "Find all medicines: {}";
        private static final String SAVE_MEDICINE_WITH_ID = "Save medicine: {} with id: {}";
        private static final String ACCEPTED_TO_SAVE = "Accepted to save medicineDTO: {}";
        private MedicineRepository medicineRepository;
        private MedicineMapper medicineMapper;
        private Logger logger = LogManager.getLogger(MedicineService.class);

        @Autowired
        public MedicineService(MedicineRepository medicineRepository, MedicineMapper medicineMapper) {
            this.medicineRepository = medicineRepository;
            this.medicineMapper = medicineMapper;
        }

        /**
         * Accept the medicineDTO, map to a medicine, save, and return its primary key
         */
        @Transactional
        public Integer save(MedicineDTO medicineDTO) {
            logger.debug(ACCEPTED_TO_SAVE, medicineDTO);
            Medicine saved = medicineRepository.save(medicineMapper.toMedicine(medicineDTO));
            Integer id = saved.getId();
            logger.debug(SAVE_MEDICINE_WITH_ID, saved, id);
            return id;
        }

        /**
         * Find all medicines, map to DTOs, and get
         */
        public List<MedicineDTO> findAll() {
            List<Medicine> medicines = medicineRepository.findAll();
            logger.debug(FIND_ALL_MEDICINES, medicines);
            return medicineMapper.toMedicineDTOList(medicines);
        }

        /**
         * Find a medicine by id, map to DTO, and get
         */
        public Optional<MedicineDTO> findById(Integer id) {
            Optional<Medicine> maybeMedicine = medicineRepository.findById(id);
            Optional<MedicineDTO> optionalMedicineDTO = Optional.empty();
            if (maybeMedicine.isPresent()) {
                Medicine medicine = maybeMedicine.get();
                logger.debug(FIND_MEDICINE_BY_ID, medicine, id);
                optionalMedicineDTO = Optional.ofNullable(medicineMapper.toMedicineDTO(medicine));
            }
            return optionalMedicineDTO;
        }

        /**
         * Accept the medicineDTO, map to a medicine, and update
         */
        @Transactional
        public void update(MedicineDTO medicineDTO) {
            logger.debug(ACCEPTED_TO_UPDATE, medicineDTO);
            Medicine medicine = medicineMapper.toMedicine(medicineDTO);
            medicineRepository.save(medicine);
            logger.debug(UPDATE_MEDICINE, medicine);
        }

        /**
         * Accept the medicineDTO, map to a medicine, and delete
         */
        @Transactional
        public void delete(MedicineDTO medicineDTO) {
            logger.debug(ACCEPTED_TO_DELETE_MEDICINE_DTO, medicineDTO);
            Medicine medicine = medicineMapper.toMedicine(medicineDTO);
            medicineRepository.delete(medicine);
            logger.debug(DELETE_MEDICINE, medicine);
        }
    }