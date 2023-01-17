package irvingmx.stockprice.store.repository;

import irvingmx.stockprice.store.entity.CompanyEntity;
import irvingmx.stockprice.store.entity.SharePriceStoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharePriceStoryRepository extends JpaRepository<SharePriceStoryEntity, Long> {

    public List<SharePriceStoryEntity> findByCompany(CompanyEntity companyEntity);

}
