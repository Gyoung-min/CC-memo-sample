package kr.couchcoding.sample.controller;

import kr.couchcoding.sample.controller.dto.CategoryDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @PostMapping("")
    public CategoryDTO CategoryController(@RequestBody CategoryDTO categoryDTO) {
        return categoryDTO;
    }
}
