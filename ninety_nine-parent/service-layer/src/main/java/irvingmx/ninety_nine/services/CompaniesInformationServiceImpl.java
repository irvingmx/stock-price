package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.store.repository.CompanyRepository;
import irvingmx.ninety_nine.store.entity.CompanyEntity;
import irvingmx.ninety_nine.store.mapper.CompanyMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("CompaniesInformationService")
public class CompaniesInformationServiceImpl implements  CompaniesInformationService {

    @Autowired
    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);

    public List<Company> getAllCompanies(){
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyEntities.stream().map(companyMapper::map).collect(Collectors.toList());
    }




}
