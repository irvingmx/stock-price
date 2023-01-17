package irvingmx.stockprice.services;

import irvingmx.stockprice.company.Company;
import irvingmx.stockprice.company.SharePrice;

import java.util.List;

public interface CompaniesInformationService {

    List<Company> getAllCompanies();
    Company getCompany(String ISIN);
    List<SharePrice> getAllSharePrices();
    SharePrice getSharePrice(String ISIN);
    List<SharePrice> getSharePriceStory(String ISIN);
    void refreshSharePrice(SharePrice sharePrice);

}
