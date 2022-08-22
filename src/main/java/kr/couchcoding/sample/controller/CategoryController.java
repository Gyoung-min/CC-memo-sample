package kr.couchcoding.sample.controller;

import kr.couchcoding.sample.dto.CategoryDTO;
import kr.couchcoding.sample.entity.Category;
import kr.couchcoding.sample.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    /*@PostMapping("")
    public CategoryDTO CategoryController(@RequestBody CategoryDTO categoryDTO) {
        return categoryDTO;
    }*/
    private final CategoryService categoryService;

    @PostMapping("")
    public Category createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }
}
