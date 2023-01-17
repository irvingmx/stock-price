package irvingmx.stockprice.store.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SharePrice")
@Data
public class SharePriceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp timestamp;
    private double price;
    @ManyToOne
    private CompanyEntity company;
}
