package test.entity;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PRODUCT", schema = "public")

public class Product {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)

    private Integer id;

    @Column(name = "PRODUCT_NAME", length = 255)
    private String productName;

    @Column(name = "PRODUCT_PRICE")
    private Integer productPrice;

    @OneToMany(mappedBy = "product")
    private Set<OrderPos> orderPos;

    @ManyToOne(targetEntity = ProductGroup.class)
    @JoinColumn (name = "PRODUCTGROUP_ID", nullable = false)
    private ProductGroup productGroup;

    public Set<OrderPos> getOrderPos() {
        return orderPos;
    }

    public void setOrderPos(Set<OrderPos> orderPos) {
        this.orderPos = orderPos;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   /* public void setOrderPoses(Set<OrderPos> orderPoses) {
        this.orderPoses = orderPoses;
    }*/
    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}