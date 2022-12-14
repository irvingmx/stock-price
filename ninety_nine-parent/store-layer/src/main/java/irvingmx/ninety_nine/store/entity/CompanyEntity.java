package irvingmx.ninety_nine.store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
@Data
public class CompanyEntity {
    @Id
    private String ISIN;
    private String simbol;
    private String market;

}
