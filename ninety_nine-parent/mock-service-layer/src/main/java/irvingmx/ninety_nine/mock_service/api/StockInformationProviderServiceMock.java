package irvingmx.ninety_nine.mock_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/stockinformationprovider/")
public interface StockInformationProviderServiceMock {

    @GetMapping("shareprices/{isin}")
    ProviderSharePrice getProviderSharePrice(@Valid @PathVariable String isin);

}
