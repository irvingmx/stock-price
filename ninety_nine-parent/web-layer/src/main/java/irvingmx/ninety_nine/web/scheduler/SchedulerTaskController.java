package irvingmx.ninety_nine.web.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SchedulerTaskController {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTaskController.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 2500)
    public void scheduleTaskWithFixedRate() {
        logger.info("Fixed Rate Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

}
