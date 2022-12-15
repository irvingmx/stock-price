package irvingmx.ninety_nine.mock_service;

import irvingmx.ninety_nine.mock_service.api.ProviderSharePrice;
import irvingmx.ninety_nine.mock_service.api.StockInformationProviderServiceMock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

@RestController
@RequestMapping("/v1")
public class BestStockInfoProviderServiceMock implements StockInformationProviderServiceMock {

    private static Random random = new Random();
    @Override
    @GetMapping("providershareprices/{isin}")
    public ProviderSharePrice getProviderSharePrice(@PathVariable String isin) {
        ProviderSharePrice providerSharePrice = new ProviderSharePrice();
        providerSharePrice.setTimestamp(Timestamp.from(Instant.now()));
        providerSharePrice.setISIN(isin);
        providerSharePrice.setPrice(generateRandomPrice());
        return providerSharePrice;
    }

    private double generateRandomPrice(){
        double priceRandom = 100;
        double bucket = random.nextInt(5) + random.nextDouble();
        return random.nextBoolean() ? priceRandom + bucket : priceRandom - bucket;
    }
}
