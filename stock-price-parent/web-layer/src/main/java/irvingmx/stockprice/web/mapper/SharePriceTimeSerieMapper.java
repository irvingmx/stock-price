package irvingmx.stockprice.web.mapper;

import irvingmx.stockprice.company.SharePriceTimeSerie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(uses = SeriesTimeTypeMapper.class)
public interface SharePriceTimeSerieMapper {

    SharePriceTimeSerie map(irvingmx.stockpriceapi.prices.SharePriceTimeSerie alienSharePriceTimeSerie);

    @InheritInverseConfiguration
    irvingmx.stockpriceapi.prices.SharePriceTimeSerie map(SharePriceTimeSerie sharePriceTimeSerie);
}
