package irvingmx.ninety_nine.web.mapper;

import irvingmx.ninety_nine.company.SharePriceTimeSerie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(uses = SeriesTimeTypeMapper.class)
public interface SharePriceTimeSerieMapper {

    SharePriceTimeSerie map(irvingmx.ninety_nine_api.prices.SharePriceTimeSerie alienSharePriceTimeSerie);

    @InheritInverseConfiguration
    irvingmx.ninety_nine_api.prices.SharePriceTimeSerie map(SharePriceTimeSerie sharePriceTimeSerie);
}
