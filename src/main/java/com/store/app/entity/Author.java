package com.store.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "CHAR(36)")
    private UUID uuid;

    @Column
    private String firstName;

    @Column
    private String lastName;

    // Description no longer than 200 characters
    @Column(length = 200)
    private String description;

    @Column
    private String avatar;

    @OneToMany(mappedBy = "author")
    List<Post> posts;
}
