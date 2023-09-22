package vn.edu.iuh.fit.huynhhuuphuoc_week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;
    @Column(length = 250, nullable = false)
    private String path;
    @Column(length = 250)
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors, getters, and setters

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImage(Long imageId, String path, String alternative, Product product) {
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public ProductImage() {
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageId=" + imageId +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", product=" + product +
                '}';
    }
}