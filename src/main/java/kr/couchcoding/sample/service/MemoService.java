package kr.couchcoding.sample.service;

import kr.couchcoding.sample.dto.MemoDTO;
import kr.couchcoding.sample.entity.Memo;
import kr.couchcoding.sample.repository.MemoRepository;
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
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoDTO memoDTO) {
        Optional<Memo> findOne = memoRepository.findByName(memoDTO.getName());

        if(findOne.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"중복된 메모이름 입니다");
        }
        Memo memo = Memo.builder()
                .name(memoDTO.getName())
                .content(memoDTO.getContent())
                .build();
        memo = memoRepository.save(memo);

        return memo;
    }

    public Memo getMemoById(Long id) {//메모 하나 가져오기
        return memoRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND, "메모가 존재하지 않습니다"));

    }

    public Page<Memo> getMemoList(Pageable pageable, String keyword) {
        if(keyword == null){
            return memoRepository.findAll(pageable);
        } else {
            return memoRepository.findByNameContains(pageable, keyword);
        }
    }

    @Transactional
    public void deleteMemoById(Long id) {
        memoRepository.deleteById(id);
    }
    @Transactional
    public void editMemoById(Long id, String content) {
        memoRepository.update(id, content);
    }
}
