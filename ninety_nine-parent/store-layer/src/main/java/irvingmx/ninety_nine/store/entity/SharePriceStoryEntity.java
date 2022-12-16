package irvingmx.ninety_nine.store.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
@Table(name = "SharePriceStory")
@Data
public class SharePriceStoryEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Timestamp timestamp;
    private double price;
    @ManyToOne
    private CompanyEntity company;

}
