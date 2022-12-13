package irvingmx.ninety_nine.company;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SharePrice {

    private LocalDateTime time;
    private double price;
    private Company company;
}
