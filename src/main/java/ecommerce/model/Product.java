package ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String size;
    private String sex;
    private double price;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProductInventory> productInventories;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderItem> orderItems;
}
