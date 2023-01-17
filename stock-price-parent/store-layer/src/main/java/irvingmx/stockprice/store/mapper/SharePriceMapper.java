package irvingmx.stockprice.store.mapper;

import irvingmx.stockprice.company.SharePrice;
import irvingmx.stockprice.store.entity.SharePriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceMapper {

    SharePriceEntity map(SharePrice sharePrice);

    @InheritInverseConfiguration
    SharePrice map(SharePriceEntity entity);
}
