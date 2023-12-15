package org.dododo.backgroundJob;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(fetchIOSUpdates.class).withIdentity("fetchIOSUpdates").storeDurably().build();
    }

    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger().forJob(jobDetail()).withSchedule(SimpleScheduleBuilder.
                repeatSecondlyForever(600)).build();
    }
}
