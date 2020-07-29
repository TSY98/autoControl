import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class Parameters {
    public sysParams[] sysParams;
    public ScheduleParms[] scheduleParams;

    public sysParams[] getSysParams() {
        return sysParams;
    }

    public void setSysParams(sysParams[] sysParams) {
        this.sysParams = sysParams;
    }

    public ScheduleParms[] getScheduleParams() {
        return scheduleParams;
    }

    public void setScheduleParams(ScheduleParms[] scheduleParams) {
        this.scheduleParams = scheduleParams;
    }
}

class sysParams{
    String key;
    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class ScheduleParms{
       String key;
       String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}