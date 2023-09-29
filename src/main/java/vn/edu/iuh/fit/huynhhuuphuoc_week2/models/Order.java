package vn.edu.iuh.fit.huynhhuuphuoc_week2.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NamedQueries(
        @NamedQuery(name = "Order.findAll", query = "select  o from Order o")
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @JsonbTransient
    @OneToMany
    private List<OrderDetail> orderDetails;

    // Constructors, getters, and setters

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Order(Long orderId, Date orderDate, Employee employee) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employee = employee;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                '}';
    }
}

