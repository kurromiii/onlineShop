package com.mftplus.onlineshop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity (name = "animeTypeEntity")
@Table (name = "animeType_tbl")
public class AnimeType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "a_name" , length = 10)
    private String name;
}
