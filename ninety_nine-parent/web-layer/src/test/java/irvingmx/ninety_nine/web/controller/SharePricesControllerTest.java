package irvingmx.ninety_nine.web.controller;

import irvingmx.ninety_nine.services.CompaniesInformationService;
import irvingmx.ninety_nine.store.repository.CompanyRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { SharePricesController.class })
//@WebMvcTest(SharePricesController.class)
//TODO Implement Test for the implementation of services with corner cases
public class SharePricesControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CompaniesInformationService companiesInformationService;
    @MockBean
    private CompanyRepository companyRepository;
   // @Test
    public void testGetAllCompanies() throws Exception {
//        given(this.companyRepository.findAll())
//                .willReturn(new ArrayList<>());
//        given(this.companiesInformationService.getAllCompanies())
//                .willReturn(new ArrayList<>());
        this.mvc.perform(get("/companies/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
    //@Test
    public void testGetCompany() {
    }
    //@Test
    public void testGetSharePrice() {
    }
    //@Test
    public void testGetSharePriceStory() {
    }

    public void testGetSharePricesStoriesByTimeSeries() {
    }
}