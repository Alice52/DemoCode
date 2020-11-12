package com.augmentum.jpa.entity;

import javax.persistence.*;

/**
 * @author zack
 * @create 2019-07-14 16:12
 * @function
 */
@Entity
@Table(name = "jpa_relations_order")
public class Order {

    private String orderName;
    private Integer id;
    private Customer customer;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID") // foreign key
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "order_name")
    public String getOrderName() {

        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
