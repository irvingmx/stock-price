package irvingmx.ninety_nine.web.mapper;

import irvingmx.ninety_nine.company.SeriesTimeType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SeriesTimeTypeMapper {

    SeriesTimeType map(irvingmx.ninety_nine_api.prices.SeriesTimeType alienSeriesTimeType);

    @InheritInverseConfiguration
    irvingmx.ninety_nine_api.prices.SeriesTimeType map(SeriesTimeType seriesTimeType);
}
