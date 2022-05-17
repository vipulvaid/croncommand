package example.commnds.cron;

public class ArgumentImpl implements Argument {
    public ArgumentImpl(String key) {
        this.key = key;
    }
    /**
     * Unique key to identify this argument;
     */
    private String key = null;
    /**
     * value of this argument;
     */
    private String value = null;
    /**
     * Type of argument value. By default its string.
     */
    private ArgumentValueType<?> argumentValueType = new StringArgumentValueType();

    @Override
    public <T> Argument type(ArgumentValueType<T> type) {
        this.argumentValueType = type;
        return this;
    }

    @Override
    public Argument setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public <T> T getValue() {
        return argumentValueType.from(value);
    }
}
