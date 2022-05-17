package example.commnds.cron;

public class StringArgumentValueType implements ArgumentValueType<String> {
    @Override
    public String from(String value) {
        return value;
    }
}
