package kr.couchcoding.sample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100, unique = true)
    String name;

    @Builder//Category category = Category.builder().name("카테고리이름").build();
    public Category(String name){
        this.name = name;
    }
}
