package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.company.SharePrice;
import irvingmx.ninety_nine.mappers.ProviderSharePriceMapper;
import irvingmx.ninety_nine.mock_service.api.ProviderSharePrice;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("SharePriceRefreshService")
public class SharePriceRefreshServiceImpl implements SharePriceRefreshService{

    private static final Logger logger = LoggerFactory.getLogger(SharePriceRefreshServiceImpl.class);
    @Autowired
    private CompaniesInformationService companiesInformationService;
    private ProviderSharePriceMapper providerSharePriceMapper = Mappers.getMapper(ProviderSharePriceMapper.class);
    @Value("${irvingmx.providerSharePrice.uri}")
    private String providerSharePriceURI;

    @Override

    public void refreshSharePrice() {
        List<Company> companies = companiesInformationService.getAllCompanies();
        logger.info("SharePriceRefreshService :: refreshSharePrices process start ...");
        companies.parallelStream().forEach( i -> {
            SharePrice alienSharePrice = getProviderSharePrice(i.getISIN());
            alienSharePrice.setCompany(i);
            companiesInformationService.refreshSharePrice(alienSharePrice);
            logger.info("Refreshed -> " + alienSharePrice);
        });
    }


    public SharePrice getProviderSharePrice(String isin) {
        String uri = providerSharePriceURI + isin;
        RestTemplate restTemplate = new RestTemplate();
        return providerSharePriceMapper.map(restTemplate.getForObject(uri, ProviderSharePrice.class));
    }

}
