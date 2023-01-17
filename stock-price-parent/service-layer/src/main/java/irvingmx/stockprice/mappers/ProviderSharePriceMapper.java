package irvingmx.stockprice.mappers;

import irvingmx.stockprice.company.SharePrice;
import irvingmx.stockprice.mock_service.api.ProviderSharePrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface ProviderSharePriceMapper {

    SharePrice map(ProviderSharePrice alienSharePrice);

    @InheritInverseConfiguration
    ProviderSharePrice map(SharePrice sharePrice);
}
