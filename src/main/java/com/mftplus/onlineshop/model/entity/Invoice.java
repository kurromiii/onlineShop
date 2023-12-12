package com.mftplus.onlineshop.model.entity;

import com.mftplus.onlineshop.model.entity.enums.InvoiceType;
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

@Entity (name = "invoiceEntity")
@Table (name = "invoice_tbl")
public class Invoice {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User customer;

    @Enumerated (EnumType.ORDINAL)
    private InvoiceType invoiceType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceItem> items = new ArrayList<>();

    private int amount;
    private int discount;
    private int pureAmount;

    //for that List
    public void addItem(InvoiceItem invoiceItem){
        items.add(invoiceItem);
    }

    @PrePersist
    public void calculateAmount(){
        int sum = 0;
        for (InvoiceItem item : items) {
            sum += item.getCount() * item.getPrice();
        }
        amount = sum;
        pureAmount = sum - discount;

    }

}
