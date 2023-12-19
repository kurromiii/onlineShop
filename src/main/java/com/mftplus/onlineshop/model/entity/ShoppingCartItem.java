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

@Entity (name = "shoppingCartItemEntity")
@Table (name = "shoppingCartItem_tbl")
public class ShoppingCartItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Stuff stuff;

    private int count;

    private int price;
}
