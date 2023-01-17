package irvingmx.stockprice.web.controller;

import irvingmx.stockprice.services.SharePriceSeriesTimeProcessorServiceImpl;
import irvingmx.stockprice.services.CompaniesInformationService;
import irvingmx.stockprice.web.mapper.CompanyMapper;
import irvingmx.stockprice.web.mapper.SeriesTimeTypeMapper;
import irvingmx.stockprice.web.mapper.SharePriceMapper;
import irvingmx.stockprice.web.mapper.SharePriceTimeSerieMapper;
import irvingmx.stockpriceapi.prices.*;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class SharePricesController implements SharePriceService {
    private static final Logger logger = LoggerFactory.getLogger(SharePricesController.class);
    @Autowired
    private CompaniesInformationService companiesInformationService;
    @Autowired
    private SharePriceSeriesTimeProcessorServiceImpl sharePriceSeriesTimeProcessorServiceMock;
    private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    private SharePriceMapper sharePriceMapper = Mappers.getMapper(SharePriceMapper.class);
    private SeriesTimeTypeMapper seriesTimeTypeMapper = Mappers.getMapper(SeriesTimeTypeMapper.class);
    private SharePriceTimeSerieMapper sharePriceTimeSerieMapper = Mappers.getMapper(SharePriceTimeSerieMapper.class);

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

    @Override
    @GetMapping("/companies/shareprices/{isin}")
    public List<SharePrice> getSharePriceStory(@PathVariable String isin) {
        return companiesInformationService.getSharePriceStory(isin).stream().map(sharePriceMapper::map).collect(Collectors.toList());
    }


    @Override
    @GetMapping("/companies/shareprices/{isin}/{seriesTimeType}")
    public List<SharePriceTimeSerie> getSharePricesStoriesByTimeSeries(@Valid @PathVariable String isin, @Valid @PathVariable SeriesTimeType seriesTimeType) {
        logger.info(isin);
        logger.info(seriesTimeType.name());
        irvingmx.stockprice.company.SeriesTimeType unalienSeriesTimeType = seriesTimeTypeMapper.map(seriesTimeType);
        return sharePriceSeriesTimeProcessorServiceMock.getSharePriceStoryBySeriesTimeType(isin,unalienSeriesTimeType).stream().map(sharePriceTimeSerieMapper::map).collect(Collectors.toList());
    }
}
