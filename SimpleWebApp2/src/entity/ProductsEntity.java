package entity;

//import jakarta.persistence.*;
//import jakarta.persistence.*;
import javax.persistence.*;
@Entity
@Table(name = "products", schema = "users", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Product_Id")
    private Long productId;
    @Basic
    @Column(name = "SectionId")
    private Integer sectionId;
    @Basic
    @Column(name = "Product")
    private String product;

    public ProductsEntity(String name, Integer sectionId){
        this.product=name;
        this.sectionId=sectionId;
    }
    public ProductsEntity(){

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (productId != that.productId) return false;
        if (sectionId != null ? !sectionId.equals(that.sectionId) : that.sectionId != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = productId;
        result = 31 * result + (sectionId != null ? sectionId.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
