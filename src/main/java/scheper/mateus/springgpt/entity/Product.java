package scheper.mateus.springgpt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scheper.mateus.springgpt.dto.ProductDTO;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;

    private Long quantity;

    private String unitType;

    private boolean active;

    public void updateProduct(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.quantity = productDTO.getQuantity();
        this.unitType = productDTO.getUnitType();
        this.active = productDTO.isActive();
    }

}



