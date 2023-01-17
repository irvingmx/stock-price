package irvingmx.stockprice.company;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SharePriceTimeSerie {
    private String serieItem;
    private SeriesTimeType seriesTimeType;
    private double averagePrice;
    private Company company;
}
