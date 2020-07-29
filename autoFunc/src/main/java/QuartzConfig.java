import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
//    @Bean
//    public JobDetail teatQuartzDetail(){
//        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
//    }
//    @Bean
//    public Trigger testQuartzTrigger(){
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
//        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail()).withIdentity("testQuartz").withSchedule(scheduleBuilder).build();
//    }
}
