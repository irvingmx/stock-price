package irvingmx.ninety_nine.store.mapper;

import irvingmx.ninety_nine.company.SharePrice;
import irvingmx.ninety_nine.store.entity.SharePriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceMapper {

    SharePriceEntity map(SharePrice sharePrice);

    @InheritInverseConfiguration
    SharePrice map(SharePriceEntity entity);
}
