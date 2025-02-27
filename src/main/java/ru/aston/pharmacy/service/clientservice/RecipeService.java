package ru.aston.pharmacy.service.clientservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.domain.client.Recipe;
import ru.aston.pharmacy.dto.clientDTO.RecipeDTO;
import ru.aston.pharmacy.dto.mappers.clientmappers.RecipeMapper;
import ru.aston.pharmacy.repository.clientrepositories.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RecipeService {
    private static final String DELETE_RECIPE = "Delete recipe: {}";
    private static final String ACCEPTED_TO_DELETE_RECIPE_DTO = "Accepted to delete recipeDTO: {}";
    private static final String UPDATE_RECIPE = "Update recipe: {}";
    private static final String ACCEPTED_TO_UPDATE = "Accepted to update recipeDTO: {}";
    private static final String FIND_RECIPE_BY_ID = "Find recipe: {} by id: {}";
    private static final String FIND_ALL_RECIPES = "Find all recipes: {}";
    private static final String SAVE_RECIPE_WITH_ID = "Save recipe: {} with id: {}";
    private static final String ACCEPTED_TO_SAVE = "Accepted to save recipeDTO: {}";
    private RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;
    private Logger logger = LogManager.getLogger(RecipeService.class);

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    /**
     * Accept the recipeDTO, map to a recipe, save, and return its primary key
     */
    @Transactional
    public Integer save(RecipeDTO recipeDTO) {
        logger.debug(ACCEPTED_TO_SAVE, recipeDTO);
        Recipe saved = recipeRepository.save(recipeMapper.toRecipe(recipeDTO));
        Integer id = saved.getId();
        logger.debug(SAVE_RECIPE_WITH_ID, saved, id);
        return id;
    }

    /**
     * Find all recipes, map to DTOs, and get
     */
    public List<RecipeDTO> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        logger.debug(FIND_ALL_RECIPES, recipes);
        return recipeMapper.toRecipeDTOList(recipes);
    }

    /**
     * Find a recipe by id, map to DTO, and get
     */
    public Optional<RecipeDTO> findById(Integer id) {
        Optional<Recipe> maybeRecipe = recipeRepository.findById(id);
        Optional<RecipeDTO> optionalRecipeDTO = Optional.empty();
        if (maybeRecipe.isPresent()) {
            Recipe recipe = maybeRecipe.get();
            logger.debug(FIND_RECIPE_BY_ID, recipe, id);
            optionalRecipeDTO = Optional.ofNullable(recipeMapper.toRecipeDTO(recipe));
        }
        return optionalRecipeDTO;
    }

    /**
     * Accept the recipeDTO, map to a recipe, and update
     */
    @Transactional
    public void update(RecipeDTO recipeDTO) {
        logger.debug(ACCEPTED_TO_UPDATE, recipeDTO);
        Recipe recipe = recipeMapper.toRecipe(recipeDTO);
        recipeRepository.save(recipe);
        logger.debug(UPDATE_RECIPE, recipe);
    }

    /**
     * Accept the recipeDTO, map to a recipe, and delete
     */
    @Transactional
    public void delete(RecipeDTO recipeDTO) {
        logger.debug(ACCEPTED_TO_DELETE_RECIPE_DTO, recipeDTO);
        Recipe recipe = recipeMapper.toRecipe(recipeDTO);
        recipeRepository.delete(recipe);
        logger.debug(DELETE_RECIPE, recipe);
    }
}