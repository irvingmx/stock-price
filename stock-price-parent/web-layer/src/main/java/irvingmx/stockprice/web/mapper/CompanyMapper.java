package irvingmx.stockprice.web.mapper;

import irvingmx.stockprice.company.Company;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company map(irvingmx.stockpriceapi.prices.Company alienCompany);

    @InheritInverseConfiguration
    irvingmx.stockpriceapi.prices.Company map(Company company);
}
