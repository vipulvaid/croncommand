package example.commnds.cron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CronArgumentValueType implements ArgumentValueType<CronArgumentValue> {

    /**
     * minimum integer value that argument value should have.
     */
    int min;
    /**
     * maximum integer value that argument value cannot exceed.
     */
    int max;

    public CronArgumentValueType(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public CronArgumentValue from(String value) {
        // value can be *
        // or 1-4 (range)
        // or 1,3,5 (specific counts)
        // or */4 (repeat)
        if ("*".equals(value)) {
            return new CronArgumentValue(IntStream.range(min, max + 1).toArray());
        } else if (value.contains("-")) {
            String[] values = value.split("-");
            if (values.length != 2) {
                throw new InvalidCronArgumentException();
            }
            int[] intValues = getIntValues(values);
            Arrays.sort(intValues);
            compare(intValues[0], intValues[intValues.length -1]);
            return new CronArgumentValue(IntStream.range(intValues[0], intValues[1] + 1).toArray());
        } else if (value.contains("/") && value.contains("*")) {
            String[] values = value.split("/");
            if (values.length != 2) {
                throw new InvalidCronArgumentException();
            }
            if (!"*".equals(values[0])) {
                throw new InvalidCronArgumentException();
            }
            int intValue = Integer.parseInt(values[1]);
            compare(intValue, intValue);
            List<Integer> integerList = new ArrayList<>();
            for (int i=min; i<=max; i+=intValue) {
                integerList.add(i);
            }
            int[] intValues = integerList.stream().mapToInt(Integer::intValue).toArray();
            return new CronArgumentValue(intValues);
        } else if (value.contains(",")) {
            String[] values = value.split(",");
            int[] intValues = getIntValues(values);
            Arrays.sort(intValues);
            compare(intValues[0], intValues[intValues.length -1]);
            return new CronArgumentValue(intValues);
        } else {
            int intValue = Integer.parseInt(value);
            compare(intValue, intValue);
            return new CronArgumentValue(new int[]{intValue});
        }
    }

    private boolean compare (int a, int b) {
        if (a >= min && b <= max) {
            return true;
        }
        throw new InvalidCronArgumentException();
    }

    private int[] getIntValues(String[] values) {
        int intValues[] = new int[values.length];
        for (int i=0; i<values.length; i++) {
            intValues[i] = Integer.parseInt(values[i]);
        }
        return intValues;
    }
}
