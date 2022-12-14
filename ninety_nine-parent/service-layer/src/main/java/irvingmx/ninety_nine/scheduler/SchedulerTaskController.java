package irvingmx.ninety_nine.scheduler;

import irvingmx.ninety_nine.services.SharePriceRefreshService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SchedulerTaskController {

    @Autowired
    private SharePriceRefreshService sharePriceRefreshService;
    private static final Logger logger = LoggerFactory.getLogger(SchedulerTaskController.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 20000)
    public void scheduleTaskWithFixedRate() {
        logger.info("Fixed Rate Task: Current Time - {}", formatter.format(LocalDateTime.now()));
        sharePriceRefreshService.refreshSharePrice();
    }

}
