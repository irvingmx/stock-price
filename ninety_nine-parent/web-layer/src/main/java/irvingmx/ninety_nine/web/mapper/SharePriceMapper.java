package irvingmx.ninety_nine.web.mapper;

import irvingmx.ninety_nine.company.SharePrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceMapper {

    SharePrice map(irvingmx.ninety_nine_api.prices.SharePrice alienSharePrice);

    @InheritInverseConfiguration
    irvingmx.ninety_nine_api.prices.SharePrice map(SharePrice sharePrice);
}
