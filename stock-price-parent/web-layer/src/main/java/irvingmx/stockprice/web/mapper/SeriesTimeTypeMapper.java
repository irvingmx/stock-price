package irvingmx.stockprice.web.mapper;

import irvingmx.stockprice.company.SeriesTimeType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SeriesTimeTypeMapper {

    SeriesTimeType map(irvingmx.stockpriceapi.prices.SeriesTimeType alienSeriesTimeType);

    @InheritInverseConfiguration
    irvingmx.stockpriceapi.prices.SeriesTimeType map(SeriesTimeType seriesTimeType);
}
