package kr.couchcoding.sample.controller;

import kr.couchcoding.sample.dto.CategoryDTO;
import kr.couchcoding.sample.entity.Category;
import kr.couchcoding.sample.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("")
    public Page<Category> getCategories(Pageable pageable, @RequestParam String keyword){
        return categoryService.getCategories(pageable, keyword);
    }
}
