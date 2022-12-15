package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.company.SharePrice;
import irvingmx.ninety_nine.exceptions.CompanyNotFoundException;
import irvingmx.ninety_nine.store.entity.SharePriceEntity;
import irvingmx.ninety_nine.store.entity.SharePriceStoryEntity;
import irvingmx.ninety_nine.store.mapper.SharePriceMapper;
import irvingmx.ninety_nine.store.mapper.SharePriceStoryMapper;
import irvingmx.ninety_nine.store.repository.CompanyRepository;
import irvingmx.ninety_nine.store.entity.CompanyEntity;
import irvingmx.ninety_nine.store.mapper.CompanyMapper;
import irvingmx.ninety_nine.store.repository.SharePriceRepository;
import irvingmx.ninety_nine.store.repository.SharePriceStoryRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CompaniesInformationService")
public class CompaniesInformationServiceImpl implements  CompaniesInformationService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SharePriceRepository sharePriceRepository;
    @Autowired
    private SharePriceStoryRepository sharePriceStoryRepository;

    private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    private SharePriceMapper sharePriceMapper = Mappers.getMapper(SharePriceMapper.class);
    private SharePriceStoryMapper sharePriceStoryMapper = Mappers.getMapper(SharePriceStoryMapper.class);


    public List<Company> getAllCompanies(){
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyEntities.stream().map(companyMapper::map).collect(Collectors.toList());
    }

    public Company getCompany(String ISIN){
        return companyMapper.map(getCompanyEntity(ISIN));
    }

    public SharePrice getSharePrice(String ISIN){
        CompanyEntity companyEntity = getCompanyEntity(ISIN);
        return sharePriceMapper.map(getSharePriceEntityByCompany(companyEntity));
    }

    public List<SharePrice> getSharePriceStory(String ISIN){
        CompanyEntity companyEntity = getCompanyEntity(ISIN);
        List<SharePriceStoryEntity> sharePriceStoryEntities = sharePriceStoryRepository.findByCompany(companyEntity);
        return sharePriceStoryEntities.stream().map(sharePriceStoryMapper::map).collect(Collectors.toList());
    }

    public void refreshSharePrice(SharePrice sharePrice){
        CompanyEntity companyEntity = getCompanyEntity(sharePrice.getCompany().getISIN());
        SharePriceEntity sharePriceEntity = getSharePriceEntityByCompany(companyEntity);
        if(sharePriceEntity == null){
            sharePriceEntity = new SharePriceEntity();
            sharePriceEntity.setCompany(companyEntity);
        }
        sharePriceEntity.setPrice(sharePrice.getPrice());
        sharePriceEntity.setTimestamp(sharePrice.getTimestamp());
        sharePriceRepository.save(sharePriceEntity);
        SharePriceStoryEntity sharePriceStoryEntity = sharePriceStoryMapper.map(sharePrice);
        sharePriceStoryRepository.save(sharePriceStoryEntity);

    }

    private CompanyEntity getCompanyEntity(String ISIN) {
        Optional<CompanyEntity> optionalCompanyEntity = companyRepository.findById(ISIN);
        if(!optionalCompanyEntity.isPresent()){
            throw new CompanyNotFoundException("Company not found in database -> " + ISIN);
        }
        return optionalCompanyEntity.get();
    }

    private SharePriceEntity getSharePriceEntityByCompany(CompanyEntity companyEntity){
        List<SharePriceEntity> sharePricesEntities = sharePriceRepository.findByCompany(companyEntity);
        Optional<SharePriceEntity> optionalSharePriceEntity = sharePricesEntities.stream().findFirst();
        if(!optionalSharePriceEntity.isPresent()) {
            return null;
        }
        return optionalSharePriceEntity.get();
    }




}
