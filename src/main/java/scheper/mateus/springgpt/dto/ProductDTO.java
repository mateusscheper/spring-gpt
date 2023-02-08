package scheper.mateus.springgpt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import scheper.mateus.springgpt.entity.Product;

import java.io.Serializable;

@Data
@Builder
public class ProductDTO implements Serializable {

    private Long idProduct;

    @NotBlank(message = "Name cannot be null, empty or blank")
    private String name;

    @NotNull(message = "Quantity cannot be null")
    private Long quantity;

    @NotBlank(message = "Unit type cannot be null, empty or blank")
    private String unitType;

    private boolean active;

    public Product toProduct() {
        return new Product(idProduct, name, quantity, unitType, active);
    }

    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getIdProduct(), product.getName(), product.getQuantity(),
                product.getUnitType(), product.isActive());
    }

}
