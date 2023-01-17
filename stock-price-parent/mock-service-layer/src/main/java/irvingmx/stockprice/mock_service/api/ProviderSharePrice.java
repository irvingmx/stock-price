package irvingmx.stockprice.mock_service.api;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
public class ProviderSharePrice {

    private String ISIN;
    private double price;
    private Timestamp timestamp;
}
