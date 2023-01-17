package irvingmx.stockprice.services;

import irvingmx.stockprice.company.Company;
import irvingmx.stockprice.company.SharePrice;
import irvingmx.stockprice.exceptions.CompanyNotFoundException;
import irvingmx.stockprice.store.entity.CompanyEntity;
import irvingmx.stockprice.store.entity.SharePriceEntity;
import irvingmx.stockprice.store.entity.SharePriceStoryEntity;
import irvingmx.stockprice.store.mapper.CompanyMapper;
import irvingmx.stockprice.store.mapper.SharePriceMapper;
import irvingmx.stockprice.store.mapper.SharePriceStoryMapper;
import irvingmx.stockprice.store.repository.CompanyRepository;
import irvingmx.stockprice.store.repository.SharePriceRepository;
import irvingmx.stockprice.store.repository.SharePriceStoryRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<SharePrice> getAllSharePrices() {
        List<SharePriceEntity> sharePriceEntities =  sharePriceRepository.findAll();
        return sharePriceEntities.stream().map(sharePriceMapper::map).collect(Collectors.toList());
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
