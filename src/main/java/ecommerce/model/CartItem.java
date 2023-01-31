package ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;


    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Product product;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

}
