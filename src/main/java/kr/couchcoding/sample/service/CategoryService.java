package kr.couchcoding.sample.service;

import kr.couchcoding.sample.dto.CategoryDTO;
import kr.couchcoding.sample.entity.Category;
import kr.couchcoding.sample.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CategoryDTO categoryDTO){
        // Repository에서 데이터 가져오기
        Optional<Category> findOne = categoryRepository.findByName(categoryDTO.getName());
        if(findOne.isPresent()){
            // 데이터가 이미 존재하면 Exception을 발생시키고 종료
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 이름입니다.");
        }
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();
        category = categoryRepository.save(category);// 아니면 category 생성하기

        return category;
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "카테고리가 존재하지 않습니다."));
    }


    public Page<Category> getCategories(Pageable pageable, String keyword) {
        if(keyword == null){
            return categoryRepository.findAll(pageable);
        } else {
            return categoryRepository.findByNameContains(pageable, keyword);
        }
    }
}