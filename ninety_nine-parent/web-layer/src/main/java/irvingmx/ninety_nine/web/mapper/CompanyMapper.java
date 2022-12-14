package irvingmx.ninety_nine.web.mapper;

import irvingmx.ninety_nine.company.Company;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company map(irvingmx.ninety_nine_api.prices.Company alienCompany);

    @InheritInverseConfiguration
    irvingmx.ninety_nine_api.prices.Company map(Company company);
}
