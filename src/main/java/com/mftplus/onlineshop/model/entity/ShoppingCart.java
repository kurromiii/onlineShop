package com.mftplus.onlineshop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@NamedQuery(name = "ShoppingCartFindUser",query = "select oo from shoppingCartEntity oo where oo.customer.username=:username")
@Entity (name = "shoppingCartEntity")
@Table (name = "shopping_cart_tbl")
public class ShoppingCart {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShoppingCartItem> items = new ArrayList<>();

    private int amount;
    private int discount;
    private int pureAmount;

    //for that List
    public void addItem(ShoppingCartItem shoppingCartItem){
        items.add(shoppingCartItem);
    }

    @PrePersist
    public void calculateAmount(){
        int sum = 0;
        for (ShoppingCartItem item : items) {

            sum += item.getCount() * item.getPrice();
        }
        amount = sum;
        pureAmount = sum - discount;

    }

}
