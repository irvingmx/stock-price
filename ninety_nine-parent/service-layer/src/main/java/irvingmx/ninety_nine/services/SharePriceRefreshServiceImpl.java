package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.company.SharePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Service("SharePriceRefreshService")
public class SharePriceRefreshServiceImpl implements SharePriceRefreshService{

    @Autowired
    private CompaniesInformationService companiesInformationService;

    @Override
    public void refreshSharePrice() {
        SharePrice sharePrice = new SharePrice();
        sharePrice.setPrice(125.25);
        sharePrice.setTimestamp(Timestamp.from(Instant.now()));
        Company company = new Company();
        company.setISIN("ES0173516115");
        sharePrice.setCompany(company);
        companiesInformationService.refreshSharePrice(sharePrice);
    }
}
