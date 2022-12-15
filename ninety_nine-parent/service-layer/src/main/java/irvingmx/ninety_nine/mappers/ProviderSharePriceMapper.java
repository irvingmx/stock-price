package irvingmx.ninety_nine.mappers;

import irvingmx.ninety_nine.company.SharePrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface ProviderSharePriceMapper {

    SharePrice map(irvingmx.ninety_nine.mock_service.api.ProviderSharePrice alienSharePrice);

    @InheritInverseConfiguration
    irvingmx.ninety_nine.mock_service.api.ProviderSharePrice map(SharePrice sharePrice);
}
