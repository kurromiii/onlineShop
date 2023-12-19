package com.mftplus.onlineshop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity (name = "stuffEntity")
@Table (name = "stuff_tbl")
public class Stuff {
    @Id
    @Column (name = "id")
    //no need for sequence, this id is for all entities
    @GeneratedValue (strategy = GenerationType.AUTO)
    public long id;

    @Column (name = "s_name", length = 30)
    private String name;

    @Column (name = "s_brand", length = 10)
    private String brand;

    //this should be a list
    @Column (name = "s_group", length = 30)
    private String group;

    @Column (name = "s_price")
    public int price;

    @OneToOne
    private AnimeType category;
}
