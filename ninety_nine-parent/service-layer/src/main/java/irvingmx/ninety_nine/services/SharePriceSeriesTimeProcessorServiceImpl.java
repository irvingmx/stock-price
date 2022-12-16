package irvingmx.ninety_nine.services;

import irvingmx.ninety_nine.company.Company;
import irvingmx.ninety_nine.company.SeriesTimeType;
import irvingmx.ninety_nine.company.SharePriceTimeSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service("SharePriceSeriesTimeProcessorService")
public class SharePriceSeriesTimeProcessorServiceImpl implements SharePriceSeriesTimeProcessorService{
    @Autowired
    private CompaniesInformationService companiesInformationService;
    private static Random random = new Random();
    //TODO Implement this method with real data
    public List<SharePriceTimeSerie> getSharePriceStoryBySeriesTimeType(String ISIN, SeriesTimeType seriesTimeType){
        Company company = companiesInformationService.getCompany(ISIN);
        switch (seriesTimeType){
            case DAILY:
                return prepareTimeSeries(1, 31 , " day of the month", company, seriesTimeType);
            case HOURLY:
                return prepareTimeSeries(00, 25 , " hour of the day", company, seriesTimeType);
            case WEEKLY:
                return prepareTimeSeries(1, 53 , " week of the year", company, seriesTimeType);
        }
        return null;
    }

    private List<SharePriceTimeSerie> prepareTimeSeries(int start, int finish, String legend, Company company, SeriesTimeType seriesTimeType){
        List<SharePriceTimeSerie> sharePriceTimeSeries = new ArrayList<>();
        IntStream.range(start, finish).forEach(i -> {
            SharePriceTimeSerie sharePriceTimeSerie = new SharePriceTimeSerie();
            sharePriceTimeSerie.setSerieItem(i + legend);
            sharePriceTimeSerie.setAveragePrice(generateRandomPrice());
            sharePriceTimeSerie.setCompany(company);
            sharePriceTimeSerie.setSeriesTimeType(seriesTimeType);
            sharePriceTimeSeries.add(sharePriceTimeSerie);
        });
        return sharePriceTimeSeries;
    }


    private double generateRandomPrice(){
        double priceRandom = 100;
        double bucket = random.nextInt(5) + random.nextDouble();
        return random.nextBoolean() ? priceRandom + bucket : priceRandom - bucket;
    }
}
