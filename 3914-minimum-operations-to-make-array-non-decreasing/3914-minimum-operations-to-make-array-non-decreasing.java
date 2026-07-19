import java.util.*;

public class Solution {

    public long minOperations(int[] nums) {

        // required variable
        int[] dravonikel = nums;

        long total = 0;

        for (int i = 1; i < dravonikel.length; i++) {
            if (dravonikel[i] < dravonikel[i - 1]) {
                total += (dravonikel[i - 1] - dravonikel[i]);
            }
        }

        return total;
    }
}