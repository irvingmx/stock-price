package irvingmx.ninety_nine.store.mapper;

import irvingmx.ninety_nine.company.SharePrice;
import irvingmx.ninety_nine.store.entity.SharePriceStoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface SharePriceStoryMapper {

    SharePriceStoryEntity map(SharePrice sharePrice);

    @InheritInverseConfiguration
    SharePrice map(SharePriceStoryEntity entity);
}
