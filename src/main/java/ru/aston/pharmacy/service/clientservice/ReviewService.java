package ru.aston.pharmacy.service.clientservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.domain.client.Review;
import ru.aston.pharmacy.dto.clientDTO.ReviewDTO;
import ru.aston.pharmacy.dto.mappers.clientmappers.ReviewMapper;
import ru.aston.pharmacy.repository.clientrepositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReviewService {
    private static final String DELETE_REVIEW = "Delete review: {}";
    private static final String ACCEPTED_TO_DELETE_REVIEW_DTO = "Accepted to delete reviewDTO: {}";
    private static final String UPDATE_REVIEW = "Update review: {}";
    private static final String ACCEPTED_TO_UPDATE = "Accepted to update reviewDTO: {}";
    private static final String FIND_REVIEW_BY_ID = "Find review: {} by id: {}";
    private static final String FIND_ALL_REVIEWS = "Find all reviews: {}";
    private static final String SAVE_REVIEW_WITH_ID = "Save review: {} with id: {}";
    private static final String ACCEPTED_TO_SAVE = "Accepted to save reviewDTO: {}";
    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;
    private Logger logger = LogManager.getLogger(ReviewService.class);

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    /**
     * Accept the reviewDTO, map to a review, save, and return its primary key
     */
    @Transactional
    public Integer save(ReviewDTO reviewDTO) {
        logger.debug(ACCEPTED_TO_SAVE, reviewDTO);
        Review saved = reviewRepository.save(reviewMapper.toReview(reviewDTO));
        Integer id = saved.getId();
        logger.debug(SAVE_REVIEW_WITH_ID, saved, id);
        return id;
    }

    /**
     * Find all reviews, map to DTOs, and get
     */
    public List<ReviewDTO> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        logger.debug(FIND_ALL_REVIEWS, reviews);
        return reviewMapper.toReviewDTOList(reviews);
    }

    /**
     * Find a review by id, map to DTO, and get
     */
    public Optional<ReviewDTO> findById(Integer id) {
        Optional<Review> maybeReview = reviewRepository.findById(id);
        Optional<ReviewDTO> optionalReviewDTO = Optional.empty();
        if (maybeReview.isPresent()) {
            Review review = maybeReview.get();
            logger.debug(FIND_REVIEW_BY_ID, review, id);
            optionalReviewDTO = Optional.ofNullable(reviewMapper.toReviewDTO(review));
        }
        return optionalReviewDTO;
    }

    /**
     * Accept the reviewDTO, map to a review, and update
     */
    @Transactional
    public void update(ReviewDTO reviewDTO) {
        logger.debug(ACCEPTED_TO_UPDATE, reviewDTO);
        Review review = reviewMapper.toReview(reviewDTO);
        reviewRepository.save(review);
        logger.debug(UPDATE_REVIEW, review);
    }

    /**
     * Accept the reviewDTO, map to a review, and delete
     */
    @Transactional
    public void delete(ReviewDTO reviewDTO) {
        logger.debug(ACCEPTED_TO_DELETE_REVIEW_DTO, reviewDTO);
        Review review = reviewMapper.toReview(reviewDTO);
        reviewRepository.delete(review);
        logger.debug(DELETE_REVIEW, review);
    }
}