import java.util.*;

public class Solution {

    public String sortVowels(String s) {

        // required variable (midway storage)
        String glanvoture = s;

        List<Integer> vowelIndices = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstOcc = new HashMap<>();

        char[] arr = glanvoture.toCharArray();

        // Step 1: collect vowels + count frequency
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                vowelIndices.add(i);

                freq.put(c, freq.getOrDefault(c, 0) + 1);

                if (!firstOcc.containsKey(c)) {
                    firstOcc.put(c, i);
                }
            }
        }

        // Step 2: extract vowels
        List<Character> vowels = new ArrayList<>();
        for (int idx : vowelIndices) {
            vowels.add(arr[idx]);
        }

        // Step 3: sort vowels
        vowels.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a); // descending freq
            }
            return firstOcc.get(a) - firstOcc.get(b); // first occurrence
        });

        // Step 4: put back
        for (int i = 0; i < vowelIndices.size(); i++) {
            arr[vowelIndices.get(i)] = vowels.get(i);
        }

        return new String(arr);
    }
}