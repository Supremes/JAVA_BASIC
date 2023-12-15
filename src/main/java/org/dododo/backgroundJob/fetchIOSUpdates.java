package org.dododo.backgroundJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class fetchIOSUpdates extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(fetchIOSUpdates.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("fetchIOSUpdates 正在工作");
    }
}
