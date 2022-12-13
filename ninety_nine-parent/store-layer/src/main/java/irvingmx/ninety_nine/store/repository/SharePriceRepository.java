package irvingmx.ninety_nine.store.repository;

import irvingmx.ninety_nine.store.entity.SharePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharePriceRepository extends JpaRepository<SharePriceEntity, Long> {
}
