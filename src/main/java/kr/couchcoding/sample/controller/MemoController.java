package kr.couchcoding.sample.controller;

import kr.couchcoding.sample.dto.MemoDTO;
import kr.couchcoding.sample.entity.Category;
import kr.couchcoding.sample.entity.Memo;
import kr.couchcoding.sample.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memo")
@AllArgsConstructor
public class MemoController {

    /*@PostMapping("")
    public MemoDTO createMemoDTO(@RequestBody MemoDTO memoDTO) {
        return memoDTO;
    }*/

    private final MemoService memoService;

    @PostMapping("")
    public Memo createMemoDTO(@RequestBody MemoDTO memoDTO) {
        return memoService.createMemo(memoDTO);
    }

    @GetMapping("/{id}")
    public Memo getMemoById(@PathVariable Long id) {
        return memoService.getMemoById(id);
    }

    @GetMapping("")
    public Page<Memo> getCategories(Pageable pageable, @RequestParam String keyword){
        return memoService.getMemoList(pageable, keyword);
    }

    @DeleteMapping("/{id}")
    public void deleteMemoById(@PathVariable Long id) {
        memoService.deleteMemoById(id);
    }

    @GetMapping("/edit")
    public void editMemoById(@RequestParam Long id,
                             @RequestParam String content) {
        memoService.editMemoById(id, content);
    }

}
