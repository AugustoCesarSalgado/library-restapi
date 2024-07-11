package com.libraryapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int year;

    @ManyToOne(targetEntity = CategoryEntity.class)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
