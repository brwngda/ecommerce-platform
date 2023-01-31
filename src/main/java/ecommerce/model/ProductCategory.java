package ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "productCategory")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Product> products;

}
