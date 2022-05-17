package example.commnds.cron;

public class CronArgumentValue {
    private int[] intValues;

    public CronArgumentValue(int[] intValues) {
        this.intValues = intValues;
    }
    int[] getValues() {
        return intValues;
    }
}
