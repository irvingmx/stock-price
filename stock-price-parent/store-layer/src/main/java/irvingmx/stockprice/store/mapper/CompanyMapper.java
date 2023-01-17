package irvingmx.stockprice.store.mapper;

import irvingmx.stockprice.company.Company;
import irvingmx.stockprice.store.entity.CompanyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    CompanyEntity map(Company company);

    @InheritInverseConfiguration
    Company map(CompanyEntity entity);

}
