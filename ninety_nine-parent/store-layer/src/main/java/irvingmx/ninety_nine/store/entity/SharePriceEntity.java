package irvingmx.ninety_nine.store.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "SharePrice")
public class SharePriceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime localDateTime;
    private double price;
    @ManyToOne
    private CompanyEntity company;
}
