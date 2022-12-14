package irvingmx.ninety_nine.store.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "SharePriceStory")
@Data
public class SharePriceStoryEntity {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime localDateTime;
    private double price;
    @ManyToOne
    private CompanyEntity company;

}
