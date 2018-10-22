package test.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PRODUCT_GROUP", schema = "public")

public class ProductGroup {

    @Id
    @Column(name = "PRODUCTGROUP_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "PRODUCTGROUP_NAME", length = 255)
    private String productGroupName;

    @Column(name = "REMARK", length = 255)
    private String remark;

    public Set<Product> getProduct() {
        return product;
    }
    @OneToMany(mappedBy = "productGroup")
    private Set<Product> product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroup) {
        this.productGroupName = productGroupName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}