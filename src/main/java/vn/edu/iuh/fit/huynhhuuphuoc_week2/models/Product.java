package vn.edu.iuh.fit.huynhhuuphuoc_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "select p from product p")
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 300, nullable = false)
    private String description;

    @Column(length = 120, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", length = 120, nullable = false)
    private String manufacturerName;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "")
    private List<ProductPrice> productPrices;

    public Product(Long productId, String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", status=" + status +
                '}';
    }
}
