package irvingmx.stockprice.web.mapper;

import irvingmx.stockprice.company.SharePrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceMapper {

    SharePrice map(irvingmx.stockpriceapi.prices.SharePrice alienSharePrice);

    @InheritInverseConfiguration
    irvingmx.stockpriceapi.prices.SharePrice map(SharePrice sharePrice);
}
