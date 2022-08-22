package kr.couchcoding.sample.repository;

import kr.couchcoding.sample.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    Optional<Memo> findByName(String name);


    Page<Memo> findByNameContains(Pageable pageable, String keyword);

    Optional<Object> deleteByName(String name);

    @Modifying
    @Query("UPDATE Memo m SET m.content = :content WHERE m.id = :id")
    void update(Long id, String content);
}
