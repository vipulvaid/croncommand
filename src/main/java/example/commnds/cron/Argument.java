package example.commnds.cron;

/**
 * Wrapper for command line argument.
 */
public interface Argument {
    <T> Argument type(ArgumentValueType<T> type);
    Argument setValue(String value);
    <T> T getValue();
}
