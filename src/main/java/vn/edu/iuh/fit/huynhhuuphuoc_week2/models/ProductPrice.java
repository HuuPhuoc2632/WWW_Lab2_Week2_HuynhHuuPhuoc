package vn.edu.iuh.fit.huynhhuuphuoc_week2.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(nullable = false, name = "price_date_time")
    private Date priceDateTime;
    @Column(nullable = false)
    private double price;
    private String note;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors, getters, and setters

    public ProductPrice(Date priceDateTime, double price, String note, Product product) {
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
        this.product = product;
    }

    public ProductPrice() {
    }


    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", product=" + product +
                '}';
    }
}
