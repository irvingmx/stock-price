package irvingmx.ninety_nine.store.repository;

import irvingmx.ninety_nine.store.entity.CompanyEntity;
import irvingmx.ninety_nine.store.entity.SharePriceStoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharePriceStoryRepository extends JpaRepository<SharePriceStoryEntity, Long> {

    public List<SharePriceStoryEntity> findByCompany(CompanyEntity companyEntity);

}
