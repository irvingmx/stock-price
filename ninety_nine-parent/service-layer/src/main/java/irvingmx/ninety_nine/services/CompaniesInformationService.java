package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.company.SeriesTimeType;
import irvingmx.ninety_nine.company.SharePrice;

import java.util.List;

public interface CompaniesInformationService {

    List<Company> getAllCompanies();
    Company getCompany(String ISIN);
    List<SharePrice> getAllSharePrices();
    SharePrice getSharePrice(String ISIN);
    List<SharePrice> getSharePriceStory(String ISIN);
    void refreshSharePrice(SharePrice sharePrice);

}
