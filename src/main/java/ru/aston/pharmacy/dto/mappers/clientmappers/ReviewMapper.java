package ru.aston.pharmacy.dto.mappers.clientmappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.client.Review;
import ru.aston.pharmacy.dto.clientDTO.ReviewDTO;
import ru.aston.pharmacy.dto.mappers.BaseMapper;

import java.util.List;

@Mapper(uses = BaseMapper.class)
public interface ReviewMapper {
    ReviewDTO toReviewDTO(Review review);
    List<ReviewDTO> toReviewDTOList(List<Review> reviews);
}
