package vn.edu.iuh.fit.huynhhuuphuoc_week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String note;

    // Constructors, getters, and setters

    public OrderDetail(Long orderDetailId, int quantity, double price, Order order, Product product, String note) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
        this.note = note;
    }

    public OrderDetail() {
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + order +
                ", product=" + product +
                ", note='" + note + '\'' +
                '}';
    }
}
