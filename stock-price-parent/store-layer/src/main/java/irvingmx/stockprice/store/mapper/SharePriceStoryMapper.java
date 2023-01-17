package irvingmx.stockprice.store.mapper;

import irvingmx.stockprice.company.SharePrice;
import irvingmx.stockprice.store.entity.SharePriceStoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceStoryMapper {

    SharePriceStoryEntity map(SharePrice sharePrice);

    @InheritInverseConfiguration
    SharePrice map(SharePriceStoryEntity entity);
}
