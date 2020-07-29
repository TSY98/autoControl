import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestQuartz2 {


    @Scheduled(cron = "0 0 0 * * ?")
    private void process() {
        System.out.println("1111111111111111");
    }
}
