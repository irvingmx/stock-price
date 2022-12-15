package irvingmx.ninety_nine.company;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class SharePrice {

    private Timestamp timestamp;
    private double price;
    private Company company;
}
