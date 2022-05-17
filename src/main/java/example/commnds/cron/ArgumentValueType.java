package example.commnds.cron;

/**
 * Type of argument value.
 */
public interface ArgumentValueType<T> {
    public <T> T from(String value);
}
