package com.newproductrest.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int content;
    private int reviewGivenBy;

    @JsonIgnore
    @ManyToOne
    private Product product;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getReviewGivenBy() {
        return reviewGivenBy;
    }

    public void setReviewGivenBy(int reviewGivenBy) {
        this.reviewGivenBy = reviewGivenBy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", content=" + content + ", reviewGivenBy=" + reviewGivenBy + ", product=" + product
                + "]";
    }

}
