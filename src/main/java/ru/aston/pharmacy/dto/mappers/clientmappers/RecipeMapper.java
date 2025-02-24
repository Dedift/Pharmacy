package ru.aston.pharmacy.dto.mappers.clientmappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.client.Recipe;
import ru.aston.pharmacy.dto.clientDTO.RecipeDTO;
import ru.aston.pharmacy.dto.mappers.BaseMapper;

import java.util.List;

@Mapper(uses = BaseMapper.class)
public interface RecipeMapper {
    RecipeDTO toRecipeDTO(Recipe recipe);
    List<RecipeDTO> toRecipeDTOList(List<Recipe> recipes);
    Recipe toRecipe(RecipeDTO recipeDTO);
    List<Recipe> toRecipeList(List<RecipeDTO> recipeDTOs);
}
