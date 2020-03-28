package com.store.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "CHAR(36)")
    private UUID uuid;

    @Column
    private String slug;

    @Column
    @CreatedDate
    private String date;

    @Column
    @LastModifiedDate
    private String modified;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Description no longer than 200 characters
    @Column(length = 200)
    private String contentDescription;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany()
    @JoinTable(
            name = "posts_categories",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @Column
    private String thumbnail;
}
