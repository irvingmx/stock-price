package irvingmx.ninety_nine.store.mapper;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.store.entity.CompanyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    CompanyEntity map(Company company);

    @InheritInverseConfiguration
    Company map(CompanyEntity entity);

}
