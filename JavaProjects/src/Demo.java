import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        int[] copyFrom = {0,1,2,3,4,5,6,7};
        int[] copyTo = {0};
        System.arraycopy(copyFrom, 2, copyTo, 0, 1);

        int[] b = Arrays.copyOf(copyFrom,2);

        Map a = new HashMap()

    }
}
