package irvingmx.ninety_nine.web.controller;

import irvingmx.ninety_nine.services.CompaniesInformationService;
import irvingmx.ninety_nine.web.mapper.CompanyMapper;
import irvingmx.ninety_nine.web.mapper.SharePriceMapper;
import irvingmx.ninety_nine_api.prices.Company;
import irvingmx.ninety_nine_api.prices.SeriesTimeType;
import irvingmx.ninety_nine_api.prices.SharePrice;
import irvingmx.ninety_nine_api.prices.SharePriceService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class SharePricesController implements SharePriceService {

    @Autowired
    private CompaniesInformationService companiesInformationService;
    private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    private SharePriceMapper sharePriceMapper = Mappers.getMapper(SharePriceMapper.class);


    @GetMapping("/companies")
    @Override
    public List<Company> getAllCompanies() {
        return companiesInformationService.getAllCompanies().stream().map(companyMapper::map).collect(Collectors.toList());
    }
    @GetMapping("/companies/{isin}")
    @Override
    public Company getCompany(@PathVariable String isin) {
        return companyMapper.map(companiesInformationService.getCompany(isin));
    }

    @GetMapping("/companies/{isin}/shareprices")
    @Override
    public SharePrice getSharePrice(@PathVariable String isin) {
        return sharePriceMapper.map(companiesInformationService.getSharePrice(isin));

    }
    @GetMapping("/companies/{isin}/shareprices/{seriesType}")
    @Override
    public List<SharePrice> getSharePrices(@PathVariable String isin, @PathVariable SeriesTimeType seriesTimeType) {
        return null;
    }
}
